/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikaProposisi;

import java.util.Scanner;

/**
 *
 * @author primaananda
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser ac = new Parser();
        System.out.print("Masukan Proposisi : ");
        String masukan = scanner.nextLine();
        ac.cekProposisi(masukan);
        System.out.print("aaa");
        System.out.println("");
    }
}
