/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.business;

import java.util.List;

/**
 *
 * @author mrloi
 */
public interface Transaction {
    String doRequest(List<String> request) throws Exception; 
}
