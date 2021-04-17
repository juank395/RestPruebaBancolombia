package com.bancolombia.api.rest.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bancolombia.api.rest.entities.InformacionBlog;
import com.bancolombia.api.rest.repositories.IInformacionBlog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
@RequestMapping("/informacionBlog")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class BlogController {

	private String url;

	public BlogController() {
		url = "https://jsonplaceholder.typicode.com/posts";
	}

	@Autowired
	private IInformacionBlog blogRepositorie;



	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object obtenerListado(@PathVariable("id") Integer id) throws JsonMappingException, JsonProcessingException{
		return consumirServicio(String.valueOf(id));
	}


	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object obtenerListado() throws JsonMappingException, JsonProcessingException{
		return consumirServicio("");
	}

	@PostMapping
	public String guardarDatos(@RequestBody InformacionBlog idBlog){
		
		String json = consumirServicio(idBlog.getId().toString());
		
		System.out.println(json);
		
		
		if(!(json.isEmpty()) && !json.contains("404")) {

			idBlog.setTitle(new JSONObject(json).get("title").toString());
			idBlog.setUserID(Integer.valueOf(new JSONObject(json).get("userId").toString()));
			idBlog.setBody(new JSONObject(json).get("body").toString());
			
			blogRepositorie.save(idBlog);
			return "Se guardo de manera exitosa el blog.";
		}
		
		
		return "No se encontro el recurso, por favor valide el dato ingresado.";
	}


	
	public String consumirServicio(String id) {
		RestTemplate template = new RestTemplate();
		try{ 
			return template.getForObject(this.url+"/"+id, String.class);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}
	
	

}
