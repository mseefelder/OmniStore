/*
 * Interface for all my pageHandlers.
 */
package com.mseefelder.omnistore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mseefelder
 */
public interface pageHandlerInterface {
    public String process(HttpServletRequest request,
                            HttpServletResponse response);
}
