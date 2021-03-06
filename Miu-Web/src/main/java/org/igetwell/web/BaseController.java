package org.igetwell.web;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 基础类控制器
 */
@Slf4j
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();

    protected static ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();

    protected static ThreadLocal<HttpSession> session = new ThreadLocal<HttpSession>();

    @ModelAttribute
    private void init(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        this.session.set(session);
        this.request.set(request);
        this.response.set(response);
    }


    public void renderReturn(String renderText){
        try {
            response.get().getWriter().write(renderText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(String renderText){
        try {
            response.get().getWriter().print(renderText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
