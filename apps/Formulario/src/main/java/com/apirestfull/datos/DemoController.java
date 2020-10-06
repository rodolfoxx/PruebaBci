package com.apirestfull.datos;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.apirestfull.model.Usuario;
import com.apirestfull.model.UsuarioP;
import com.apirestfull.model.Usuario_Final;
import com.apirestfull.model.Autenticacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.MediaType;
import org.json.JSONObject;

@Controller
public class DemoController {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@PostMapping("/datos")
	public String envioDatos(Model modelo, Usuario usuario) {

		String resultado = "";
		
		try {
			if (!usuario.getName().isEmpty() && !usuario.getName().isEmpty() && !usuario.getEmail().isEmpty() && isNumeric(usuario.getNumber().toString()) == true && isNumeric(usuario.getCitycode().toString()) == true  && isNumeric(usuario.getContrycode().toString()) == true)   {
	
				String autentificacion = autentificar();
				String token = autentificacion.substring(10, 200);

				if (!token.isEmpty()) {

					ArrayList telefono = new ArrayList();
				
					Usuario_Final datosf = new Usuario_Final();
					
					datosf.setName(usuario.getName());
					datosf.setEmail(usuario.getEmail());
					datosf.setPassword(usuario.getPassword());
					datosf.setToken(token);

					UsuarioP dtelef = new UsuarioP();

					dtelef.setNumber(String.valueOf(usuario.getNumber()));
					dtelef.setCitycode(String.valueOf(usuario.getCitycode()));
					dtelef.setContrycode(String.valueOf(usuario.getContrycode()));
					telefono.add(dtelef);
				
					datosf.setPhones(telefono);

					String envio = enviodatos(datosf, token);
					
					
				     modelo.addAttribute("resultado",envio);
				}else {

					 modelo.addAttribute("resultado","Valide la autenticación con la api");
				}

			}else {
				
				 modelo.addAttribute("resultado","Valide los datos de entrada");
			}
			return "index";

		} catch (Exception e) {
			// TODO Auto-generated catch block
		    modelo.addAttribute("resultado","Existe un error favor valide");
			return "index";

		}


	}

	public String autentificar() {

		JSONObject jsonObj[] = new JSONObject[4];
		try {

			Autenticacion datos = new Autenticacion();

			datos.setPassword("password");
			datos.setUsername("pruebaApiRestFull");

			OkHttpClient client = new OkHttpClient();
			String urlService = "http://localhost:8080/authenticate";
			MediaType mediaType = MediaType.parse("application/json");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(datos);

			jsonObj[0] = new JSONObject(json);

			RequestBody body = RequestBody.create(mediaType, json.getBytes(StandardCharsets.UTF_8));

			Request request = new Request.Builder().url(urlService).post(body)
					.addHeader("Content-Type", "application/json").build();

			Response response = client.newCall(request).execute();
			String json2 = response.body().string().toString();

			jsonObj[2] = new JSONObject(json2);

			return json2;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// logger.error("Error en el servicio Axissin013Service - cierreOrdenBoreal",
			// e);
		}

		return "";

	}

	public String enviodatos(Usuario_Final usuario, String token) {

		JSONObject jsonObj[] = new JSONObject[4];
		try {

			OkHttpClient client = new OkHttpClient();
			String urlService = "http://localhost:8080/saveUsuario";
			MediaType mediaType = MediaType.parse("application/json");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(usuario);

			jsonObj[0] = new JSONObject(json);

			RequestBody body = RequestBody.create(mediaType, json.getBytes(StandardCharsets.UTF_8));

			Request request = new Request.Builder().url(urlService).post(body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + token).build();
					

			Response response = client.newCall(request).execute();
			String json2 = response.body().string().toString();

			jsonObj[1] = new JSONObject(json2);

			return json2;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// logger.error("Error en el servicio Axissin013Service - cierreOrdenBoreal",
			// e);
		}

		return null;

	}
	
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

}
