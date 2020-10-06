package com.apirestfull.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirestfull.model.Mensaje;
import com.apirestfull.model.Usuario;
import com.apirestfull.vo.ResultadoVO;
import com.apirestfull.vo.ResultadoVO2;

import org.springframework.http.ResponseEntity;

import com.apirestfull.dao.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	private Mensaje mensaje;

	@PostMapping("/saveUsuario")
	public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) {

		try {

			/* variables */

			ArrayList Datos = new ArrayList();
			ArrayList datosAlmacenados = new ArrayList();
			ArrayList datosAlmacenados2 = new ArrayList();

			Integer existe = 0;
			Integer ultimo = 0;
			String fechaActual;
			String nombres;

			/* ------------------------------- */

			/* validamos los campos */
			if (validarClave(usuario.getPassword().trim()) == true) {

				if (ValidarMail(usuario.getEmail().trim()) == true) {

					ResultadoVO salida = new ResultadoVO();

					Datos = usuario.getPhones();
					nombres = usuario.getName();

					Map valores = (Map) Datos.get(0);

					BigDecimal number = new BigDecimal(String.valueOf(valores.get("number")));
					BigDecimal citycode = new BigDecimal(String.valueOf(valores.get("citycode")));
					BigDecimal contrycode = new BigDecimal(String.valueOf(valores.get("contrycode")));

					usuario.setNumber(number);
					usuario.setCitycode(citycode);
					usuario.setContrycode(citycode);

					datosAlmacenados = (ArrayList) repository.findAll();

					if (datosAlmacenados.size() > 0) {

						for (int i = 0; i < datosAlmacenados.size(); i++) {

							if (repository.findAll().get(i).getEmail().equals(usuario.getEmail())) {
								salida.setMensaje("El correo ya existe",
										String.valueOf(repository.findAll().get(i).getId()),
										String.valueOf(repository.findAll().get(i).getCreatedAt()),
										String.valueOf(repository.findAll().get(i).getUpdatedAt()),
										String.valueOf(repository.findAll().get(i).getCreatedAt()),
										usuario.getToken(), "1");
								existe = 1;
								break;
							}
						}

						if (existe == 0) {
							repository.save(usuario);

							datosAlmacenados2 = (ArrayList) repository.findAll();
							ultimo = datosAlmacenados2.size() - 1;
							salida.setMensaje("OK-000", String.valueOf(repository.findAll().get(ultimo).getId()),
									String.valueOf(repository.findAll().get(ultimo).getCreatedAt()),
									String.valueOf(repository.findAll().get(ultimo).getUpdatedAt()),
							 	    String.valueOf(repository.findAll().get(ultimo).getCreatedAt()), usuario.getToken(), "1");
						}

					} else {

						repository.save(usuario);

						datosAlmacenados = (ArrayList) repository.findAll();
						ultimo = datosAlmacenados.size() - 1;
						salida.setMensaje("OK-000", String.valueOf(repository.findAll().get(ultimo).getId()),
								String.valueOf(repository.findAll().get(ultimo).getCreatedAt()),
								String.valueOf(repository.findAll().get(ultimo).getUpdatedAt()),
								String.valueOf(repository.findAll().get(ultimo).getCreatedAt()),usuario.getToken(),
								"1");

					}

					return new ResponseEntity<ResultadoVO>(salida, HttpStatus.OK);

				} else {
					ResultadoVO2 salida = new ResultadoVO2();
					salida.setMensaje("El mail no es valido o los campos que esta ingresando estan vacios");
					return new ResponseEntity<ResultadoVO2>(salida, HttpStatus.OK);

				}

			} else {

				ResultadoVO2 salida = new ResultadoVO2();
				salida.setMensaje("La password no cumple con los requisitos solicitados");
				return new ResponseEntity<ResultadoVO2>(salida, HttpStatus.OK);

			}

		} catch (Exception e) {

			ResultadoVO2 salida = new ResultadoVO2();

			salida.setMensaje(e.getMessage());

			return new ResponseEntity<ResultadoVO2>(salida, HttpStatus.OK);
		}

	}

	@GetMapping("/getAllUsuario")
	public List<Usuario> getAll() {
		return repository.findAll();

	}

	public String formatoFecha(String Fecha) {

		try {

			SimpleDateFormat d = new SimpleDateFormat("ddMMyyyy");

			Date fechaIngresada = d.parse(Fecha);
			Calendar c1 = Calendar.getInstance();
			c1.setTime(fechaIngresada);

			return c1.toString();

		} catch (Exception e) {

			return null;
		}

	}

	public boolean ValidarMail(String email) {
		// Patron para validar el email
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);
		return mather.find();
	}

	public boolean validarClave(String valores) {

		String password = valores;

		char clave;
		byte contNumero = 0, contLetraMay = 0, contLetraMin = 0;
		for (byte i = 0; i < password.length(); i++) {
			clave = password.charAt(i);
			String passValue = String.valueOf(clave);
			if (passValue.matches("[A-Z]")) {
				contLetraMay++;
			} else if (passValue.matches("[a-z]")) {
				contLetraMin++;
			} else if (passValue.matches("[0-9]")) {
				contNumero++;
			}
		}

		if (contLetraMay == 1 && contLetraMin > 0 && contNumero == 2) {

			return true;

		} else {

			return false;
		}

	}

}
