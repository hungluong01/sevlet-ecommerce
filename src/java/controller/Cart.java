/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CartItem;

/**
 *
 * @author ToanPham
 */
public class Cart extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get removeProductID & size from request
            int removeProductID = Integer.parseInt(request.getParameter("removeProductID"));
            int size = Integer.parseInt(request.getParameter("sizeID"));
            ArrayList<CartItem> cart = (ArrayList<CartItem>) request.getSession().getAttribute("cart");

            // If cart is not null &
            // ProductID & Size exists, remove this item from the list
            if (cart != null) {
                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i).getProduct().getProductID() == removeProductID && cart.get(i).getSize().getSizeID() == size) {
                        cart.remove(i);
                    }
                }
            }

            // Reassign cart
            request.getSession().setAttribute("cart", cart);
        } catch (Exception e) {
        }
        request.getServletContext().getRequestDispatcher("/cartView.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
