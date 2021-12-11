package tobi.springTest;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/app")
public class Endpoints {

	private static final String APP_JSON = "application/json";
	
	private Logger logger;
	
	public Endpoints() {
		this.logger = LoggerFactory.getLogger(Endpoints.class);
	}
	
	@PostMapping(value = "/register", consumes = APP_JSON, produces = APP_JSON)
	private @ResponseBody String register(@Validated @RequestBody PlayerRegistrationRequest request) {
		logger.info("Received request: " + request.getPrintString());
		return request.getPrintString();
	}
	
	@PostMapping(value = "/createGame", consumes = APP_JSON, produces = APP_JSON)
	private @ResponseBody String createGame(@Validated @RequestBody GameCreationRequest request) {
		logger.info("Received request: " + request.getPrintString());
		return request.getPrintString();
	}
	
	@ExceptionHandler({ RuntimeException.class })
	public @ResponseBody String handleException(Exception exception, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return exception.getMessage();
	}
}
