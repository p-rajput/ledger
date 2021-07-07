package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String name; //name of user
    Map<String,Bank> bank;  //List of Banks User has Taken Loan
    Map<String,List<Lump>> lump; //list of lump map to bank name

    public User(String name) {
        this.name = name;
        bank = new HashMap<>();
        lump = new HashMap<>();
    }
    
    public void loan(String bankIn,Long pa,int rate, int time){
        if(!bank.containsKey(bankIn)){
            Bank newBank = new Bank(bankIn,pa,rate,time);
            bank.put(bankIn,newBank);
        }
    }

    public void payment(String bankIn,Long lum,int emi){
        if(lump.get(bankIn) == null){
            List<Lump> temp = new ArrayList<>();
            Lump tempLump = new Lump(lum,emi);
            temp.add(tempLump);
            lump.put(bankIn, temp);
        }
        else{
            List<Lump> l = lump.get(bankIn);
            Lump tempLump = new Lump(lum,emi);
            l.add(tempLump);
        }

    }

    public BalanceReturn balance(String bankIn,int emiNo){
        BalanceReturn ans = new BalanceReturn();
        Integer emno;
        Bank bk = bank.get(bankIn);
        int rate = bk.getRate();
        int time = bk.getTime();
        Long amount = bk.getAmount();
        Double in = Math.ceil((amount.doubleValue()*Double.valueOf(rate)*Double.valueOf(time))/100);
        Long total = amount + in.longValue();
        Double emiD = Math.ceil(total.doubleValue()/(12d*Double.valueOf(time)));
        Long emi = emiD.longValue();
        Long totalAmount = emi*(Long.valueOf(emiNo));
        //System.out.println("Amount Loan "+total+" rate "+rate+" emi "+emi+" totalAmount paid "+totalAmount);
        if(lump.get(bankIn)!=null){
            List<Lump> l =lump.get(bankIn);
            for(int i=0;i<l.size();i++){
                if(l.get(i).getNumber()<=emiNo){
                    totalAmount+=l.get(i).amount;
                }
            }
        }
        Long rem = total - totalAmount;
        if(rem!=0&&rem<=emi)
        emno=1;
        else if(rem==0)emno=0;
        else{
            Double emnoD = Math.ceil(rem.doubleValue()/emi.doubleValue());
            emno = emnoD.intValue();
        }
        ans.setAmount(totalAmount);;
        ans.setNumber(emno);
        return ans;
    }
    
}
