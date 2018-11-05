package controller;



import validate.IValidacion;
import validate.ValidacionCadenaSinEspacio;
import validate.ValidacionDNINIECIF;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/valiCliIn")
public class ValidarClientInsertController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        //out.println("TestServlet says hi<br/>");
        RequestDispatcher rd = request.getRequestDispatcher("clientInsert.jsp");

        ArrayList <IValidacion> validaciones = new ArrayList<>();

        String clientFirstName = request.getParameter("clientFirstName");

        validaciones.add(new ValidacionCadenaSinEspacio(clientFirstName));

        String dniCliente = request.getParameter("dniCliente");

        validaciones.add(new ValidacionDNINIECIF(dniCliente));


        for (int i = 0; i < validaciones.size(); i++) {

            if(!validaciones.get(i).validar()){

                request.setAttribute("error", validaciones.get(i).getError());

            }

        }

        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
