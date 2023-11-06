package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    int lastQuotation;
    List<Quotation> quotations;

    App() {
        sc = new Scanner(System.in);
        lastQuotation = 0;
        quotations = new ArrayList<>();
    }
    public void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String wt = sc.nextLine();

            Rq rq = new Rq(wt);

            System.out.println(rq.getAction());

            if (wt.equals("종료")) {
                break;
            } else if (wt.equals("등록")) {
                register();

            } else if (wt.equals("목록")) {
                registerList();

            } else if(wt.startsWith("삭제")){
                registerRemove(wt);
            } else if(wt.startsWith("수정")){
                registerModify(wt);
            }

        }
    }

    void register() {
        System.out.print("명언 : ");
        String title = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        lastQuotation++;

        int num = lastQuotation;

        Quotation quotation = new Quotation(num, title, author);
        quotations.add(quotation);

        System.out.println(lastQuotation + "번 명언이 등록되었습니다.");
    }
    void registerList() {
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

    }
    void registerRemove(String wt){

        int num = getParamAsInt(wt,"num",0);

        if( num == 0) {
            System.out.println("id를 입력해주세요");
            return;
        }
        System.out.printf("%d번 명언을 삭제합니다.\n",num);

    }
    void registerModify(String wt) {

        int num = getParamAsInt(wt, "num",0);

        if( num == 0) {
            System.out.println("id를 수정해주세요");
            return;
        }
        System.out.printf("%d번 명언을 수정합니다.\n", num);
        }
    int getParamAsInt(String wt,String paramName, int defaultValue){
        String[] wtBits = wt.split("\\?", 2);
        String queryString = wtBits[1];

        String[] queryStringBits =queryString.split("&");

        for(int i = 0; i< queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];

            String[] queryParamStrBits = queryParamStr.split("=", 2);

            String _paramName = queryParamStrBits[0];
            String paramValue = queryParamStrBits[1];

            if(_paramName.equals(paramName)) {
                try {
                    return Integer.parseInt(paramValue);
                }
                catch (NumberFormatException e){
                    return defaultValue;

                }
            }
        }
        return defaultValue;
    }
}
