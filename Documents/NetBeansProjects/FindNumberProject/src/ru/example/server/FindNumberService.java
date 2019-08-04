/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.example.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import ru.example.entity.Result;

/**
 *
 * @author Philipp
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface FindNumberService {

    @WebMethod
    public Result getResultToString(@WebParam(name = "number") int number);

    @WebMethod
    public void writeIntoDB(@WebParam(name = "number") int number);
}
