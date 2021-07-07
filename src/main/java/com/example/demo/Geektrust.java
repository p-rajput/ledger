package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class Geektrust {

	public static void main(String[] args) throws FileNotFoundException , IOException{
		String file = args[0];//"C:/Users/prabh/Documents/nav.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		//user name mapped to that paticular user class
		Map<String,User> user = new HashMap<>();

		while ((st = br.readLine()) != null){
			String [] lines = st.split(" ");
			
			if(lines[0].equalsIgnoreCase("LOAN")){
				if(user.containsKey(lines[2])){
					User tmpUser = user.get(lines[2]);
					tmpUser.loan(lines[1], Long.valueOf(lines[3]), Integer.parseInt(lines[5]), Integer.parseInt(lines[4]));
				}else{
					User tmpUser = new User(lines[2]);
					tmpUser.loan(lines[1], Long.valueOf(lines[3]), Integer.parseInt(lines[5]), Integer.parseInt(lines[4]));
					user.put(lines[2], tmpUser);
				}

			}else if(lines[0].equalsIgnoreCase("PAYMENT")){
				User tmpUser = user.get(lines[2]);
				tmpUser.payment(lines[1], Long.valueOf(lines[3]), Integer.parseInt(lines[4]));
				
			}else if(lines[0].equalsIgnoreCase("BALANCE")){
				User tmpUser = user.get(lines[2]);
				BalanceReturn ans = tmpUser.balance(lines[1], Integer.parseInt(lines[3]));
				System.out.println(lines[1]+" "+lines[2]+" "+ans.getAmount()+" "+ans.getNumber());
			}
		}
	}

}
