package com.javacreed.examples.maven;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

  private static final long serialVersionUID = 1533532266743443618L;

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
      IOException {
    /* Set response content type */
    response.setContentType("text/html");

    try (PrintWriter out = response.getWriter()) {
      out.println("<html><body><h1>Hello :)</h1><p>I am running on an embedded Tomcat, thanks to Maven</p></body></html>");
    }
  }
}
