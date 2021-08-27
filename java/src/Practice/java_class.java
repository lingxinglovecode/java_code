package Practice;

import javax.swing.text.StyledEditorKit;

public class java_class {
    public static void main(String[] args){
    Account my_account = new Account();
    my_account.cid = "12345567";
    my_account.balance = 10000;
    my_account.name = "lingxing";
    my_account.getInfo();
    my_account.withdraw(200);
    my_account.getInfo();
    Customer lingxing = new Customer();
    System.out.println(lingxing.say());
    }
}



class Account{
    String cid ;
    int balance = 1234;
    String name;

    public void getInfo(){
        System.out.println("卡号\t\t\t余额\t\t姓名");
        System.out.println(cid+'\t'+balance+'\t'+name);
    }
    public boolean withdraw(int num){
        if(num>=0 && balance>=num)
        {
            balance = balance - num;
            return true;
        }
        else{
            return false;
        }

    }

    public boolean save(int num){
        if(num<=0){
            return false;
        }
        else {
            balance = balance+num;
            return true;
        }

    }



}

class Customer{
    String name;
    String id;
    String number;
    String addr;

    public String say(){
        String info = "name:"+name+"\n"+"id:"+id+"\n"+"number:"+number+"\n"+"address:"+addr;
        return info;
    }


}