package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");
        int lastQuotation = 0;
        List<Quotation> quotations = new ArrayList<>();

        while(true) {
            System.out.print("명령) ");

            Scanner sc = new Scanner(System.in);
            String wt = sc.nextLine();


            
            if (wt.equals("종료")) {
                break;
            } else if (wt.equals("등록")) {

                System.out.print("명언 : ");
                String title = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                lastQuotation++;

                int num = lastQuotation;

                Quotation quotation = new Quotation(num, title, author);

                System.out.println(lastQuotation + "번 명언이 등록되었습니다.");
                quotations.add(quotation);

            } else if (wt.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                //System.out.println(quotations.size() + "/" + author + "/" + title);

                if(quotations.isEmpty()){
                    System.out.println("등록된 명언이 없습니다.");
                }

                for(int i =quotations.size()-1; i >=  0; i--){
                    Quotation quotation =quotations.get(i);
                    System.out.printf("%d / %s / %s\n", quotation.num, quotation.author, quotation.title);
                }

            } else if(wt.equals("삭제")){

            }

        }
    }
}
