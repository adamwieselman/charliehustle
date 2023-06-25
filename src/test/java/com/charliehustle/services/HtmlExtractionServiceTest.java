package com.charliehustle.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.charliehustle.models.CbsPlayer;

public class HtmlExtractionServiceTest
{
   //@Test
//   public void testExtractBaseballSavantCurrentToDateJson ()
//      throws UnirestException, IOException, InterruptedException
//   {
//      UnirestApiService unirestApiService = new UnirestApiService();
//      JsonMapper jsonMapper = new JsonMapper();
//      UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
//      unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
//      HtmlExtractionService htmlExtractionService = new HtmlExtractionService();
//      htmlExtractionService.unirestApiService = unirestApiService;
//      unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
//      htmlExtractionService.jsonMapper = jsonMapper;
//
//      //BaseballSavantData baseballSavantCurrentToDate = htmlExtractionService.extractBaseballSavantCurrentToDateJson("Batter");
//      BaseballSavantData baseballSavantToADate = htmlExtractionService.extractBaseballSavantVariableTimeframeJson("Batter",7);
//   }

  // @Test
   public void testStuff()
      throws IOException, InterruptedException
   {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
                                       .setHeader("Cookie", "fly_ab_uid=1d5f31d2-bfb8-4f07-8621-edddf267fe43; s_ecid=MCMID%7C81314969006814342222961627495615820593; _ga=GA1.2.411753532.1646089360; _gcl_au=1.1.890909056.1646089361; _fbp=fb.1.1646089361682.529219217; __gads=ID=c5a718601915dd77:T=1646089359:S=ALNI_MZMakBcTTgrtYCFv5JiqaMZCjtnqg; _admrla=2.0-f8236be6-afc9-e6af-1305-5c0a548d86e1; aam_uuid=81108198237429598942976415863623530057; pid=L%3A140%3A3NJE4pt5zcE%252B5dhf8AxnDw%253D%253D%3A1; anon=FALSE; ppid=b9468dbb51463b557d6ec8bdf4ace139; _cc_id=332dd81b0cd23a29f816341beb033b26; seen_baseball_2022_fantasy_newsletter=1648738245; cbsiaa=31185664; _pbjs_userid_consent_data=3524755945110770; _pubcid=37863345-243c-4552-9ba6-97111fbcb7e6; _lr_env_src_ats=false; _cb_ls=1; _cb=Da3r2BBAuB5Czg9le; trc_cookie_storage=taboola%2520global%253Auser-id%3D6173013e-3537-4283-8642-f5578c9d48fe-tuct8a681ff; __qca=P0-1962571406-1649727471116; initial_referrer=FRFB15_fn_myteams_drpdwn; aamgam=segid%3D17873420%2C17873364%2C17872405%2C18582211%2C16185172%2C16007068%2C14545733%2C13607396%2C12735092%2C12734882%2C12681061%2C1608821%2C13100219; AAMC_cbsi_0=REGION%7C7%7CAMSYNCSOP%7C%7CAMSYNCS%7C; panoramaId_expiry=1653527578047; panoramaId=78a8cad4773afdf08a52e06d469f4945a702a590a7fd14f86ef484487ac8f3e9; _BB.id.identityLink=Ao5VsqkyOO1HZvc-lwl7CK23fzhlrQcFzBKE42Ke2jZsQCj4sAVniroYWEfscoLqcDnnVv8HiE_eMlWYJFkB2q8fMoN9KzrvV8ad; cto_bundle=qH_1h19yYURxZGttMGJHV0U4RzNQNm5sbHJHYjdxbTFSUWthZmNQSllNV0FKeiUyQnpNR2tkNlBvU3Y0RDR1Wm1jR0lWQ2g1Sk96b2NnMnVkRGRaMDJUb3plZlNJdzdFZktWUGQyOUNOdVZlS1l1JTJGZyUyRlFkYlhwaVZIV1JSR09ROGZSb2l0bnMzM0NkVVRZSklMU2xSUzJlNGNRQ2clM0QlM0Q; cto_bidid=XX3wXV9acG92ODRVYmZpYVdRd2R5VGl6WFJjUVNWNmRWTXk3T2ZWeHp4S2t6M3lQUDd5bkpnMnV3dXAlMkI1aDdPOERnYjg2JTJCSHRjY2d2ZUlObDFSVGYlMkZSSzJUUVpaWiUyRlElMkJjSGMxMDRXTlVMNlF3c28lM0Q; _gid=GA1.2.676474507.1653050160; _awl=2.1653050393.0.5-f8236be6afc9e6af13055c0a548d86e1-6763652d75732d63656e7472616c31-0; XFP_FIRSTPAGE=0; _chartbeat2=.1648738255637.1653135768995.1100011111001011.B1pprojcnteDw_E2CZ1m4BBoFWRi.2; _lr_geo_location=US; __gpi=UID=0000046c9f94b0be:T=1649685171:RT=1653191613:S=ALNI_MZkuyFgWo4d4Qz2fZIFAg0dpl88gg; _BB.id.liveIntent=%7B%22unifiedId%22%3A%22U8xua2ddCX54KiL_Ey9bL3uqBTu6pJGhRBzUOQ%22%7D; fly_geo={\"countryCode\":\"us\",\"region\":\"wi\"}; region_code=WI; surround=b|1; _BB.bs=b|1; AMCVS_10D31225525FF5790A490D4D%40AdobeOrg=1; AMCV_10D31225525FF5790A490D4D%40AdobeOrg=-1712354808%7CMCIDTS%7C19134%7CMCMID%7C81314969006814342222961627495615820593%7CMCAAMLH-1653796713%7C7%7CMCAAMB-1653796713%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1653199113s%7CNONE%7CMCAID%7CNONE%7CvVersion%7C4.3.0%7CMCCIDH%7C-1547458224; QSI_HistorySession=https%3A%2F%2F2007bkl.baseball.cbssports.com%2F~1653191913841; s_cc=true; cto_bundle=iOpySF9yYURxZGttMGJHV0U4RzNQNm5sbHJHbFk3WUtDOE9PalNlSTZCRUtMQnFRclEwNk5BaVBKbiUyQnRXaVpzYTN3cGtUS1JkZ1UwJTJCYVR3YUIlMkY2Y3hwSW1TS2JxNEVURE1PMW4zRFZGUVhFeDVTeWhIZVF3bDNlSjNES3BxQzNpcjFlT3NrdTVYNkRhOGprb1NaeWFEcnl2eWclM0QlM0Q; cto_bundle=iOpySF9yYURxZGttMGJHV0U4RzNQNm5sbHJHbFk3WUtDOE9PalNlSTZCRUtMQnFRclEwNk5BaVBKbiUyQnRXaVpzYTN3cGtUS1JkZ1UwJTJCYVR3YUIlMkY2Y3hwSW1TS2JxNEVURE1PMW4zRFZGUVhFeDVTeWhIZVF3bDNlSjNES3BxQzNpcjFlT3NrdTVYNkRhOGprb1NaeWFEcnl2eWclM0QlM0Q; cto_bundle=iOpySF9yYURxZGttMGJHV0U4RzNQNm5sbHJHbFk3WUtDOE9PalNlSTZCRUtMQnFRclEwNk5BaVBKbiUyQnRXaVpzYTN3cGtUS1JkZ1UwJTJCYVR3YUIlMkY2Y3hwSW1TS2JxNEVURE1PMW4zRFZGUVhFeDVTeWhIZVF3bDNlSjNES3BxQzNpcjFlT3NrdTVYNkRhOGprb1NaeWFEcnl2eWclM0QlM0Q; cto_bidid=Xi2RrF9acG92ODRVYmZpYVdRd2R5VGl6WFJjUVNWNmRWTXk3T2ZWeHp4S2t6M3lQUDd5bkpnMnV3dXAlMkI1aDdPOERnYjg2JTJCSHRjY2d2ZUlObDFSVGYlMkZSSzJUUlY5NUJrZ0VibG5YZmRQT1ZYZ0Q0QSUzRA; cto_bidid=Xi2RrF9acG92ODRVYmZpYVdRd2R5VGl6WFJjUVNWNmRWTXk3T2ZWeHp4S2t6M3lQUDd5bkpnMnV3dXAlMkI1aDdPOERnYjg2JTJCSHRjY2d2ZUlObDFSVGYlMkZSSzJUUlY5NUJrZ0VibG5YZmRQT1ZYZ0Q0QSUzRA; cto_bidid=Xi2RrF9acG92ODRVYmZpYVdRd2R5VGl6WFJjUVNWNmRWTXk3T2ZWeHp4S2t6M3lQUDd5bkpnMnV3dXAlMkI1aDdPOERnYjg2JTJCSHRjY2d2ZUlObDFSVGYlMkZSSzJUUlY5NUJrZ0VibG5YZmRQT1ZYZ0Q0QSUzRA; _BB.d=0|||15; OptanonAlertBoxClosed=2022-05-22T04:00:19.861Z; last_access=1653192020; OptanonConsent=isIABGlobal=false&datestamp=Sat+May+21+2022+23%3A00%3A20+GMT-0500+(Central+Daylight+Time)&version=6.30.0&hosts=&consentId=bbbbb8a4-09ee-44b8-8a0c-29c0ca205920&interactionCount=1&landingPath=NotLandingPage&groups=1%3A1%2C2%3A1%2C3%3A1%2C4%3A1%2C5%3A1&AwaitingReconsent=false&geolocation=US%3BWI; utag_main=v_id:017f429246d90016d6cc90550b9105073008306b007e8$_sn:118$_ss:0$_st:1653193821091$vapi_domain:cbssports.com$dc_visit:116$_se:1$ses_id:1653191612246%3Bexp-session$_pn:4%3Bexp-session$dc_event:4%3Bexp-session$dc_region:us-east-1%3Bexp-session; fantasy_cookie=%3A8000%3A1653191873%3A2007bkl.baseball.cbssports.com; _dd_s=logs=1&id=3ea34496-e524-489d-9b65-52fd9fa2d5e3&created=1653191611893&expire=1653193466803; s_sq=cbsicbssportssite%3D%2526c.%2526a.%2526activitymap.%2526page%253Dcbssports%25253A%25252Fmlb%25252Fmgmt%25252Fgold%25252Fhome%2526link%253DSTATS%2526region%253DfantNavPopupMenu%2526pageIDType%253D1%2526.activitymap%2526.a%2526.c%2526pid%253Dcbssports%25253A%25252Fmlb%25252Fmgmt%25252Fgold%25252Fhome%2526pidt%253D1%2526oid%253Dhttps%25253A%25252F%25252F2007bkl.baseball.cbssports.com%25252Fstats%25252Fstats-main%2526ot%253DA; RT=\"z=1&dm=cbssports.com&si=fbd49c63-8cb7-4d4b-9819-dae62593b264&ss=l3grlli6&sl=3&tt=jqn&bcn=%2F%2F173bf10a.akstat.io%2F&nu=2r8v3e2d&cl=kiyb&ul=kiz4\"")
                                       .uri(URI.create("https://2007bkl.baseball.cbssports.com/stats/stats-main/all:C:1B:2B:3B:SS:MI:CI:OF:DH/period-28:p/Stuff3?print_rows=9999"))
                                       .build();

      HttpResponse<String> response =
         client.send(request, HttpResponse.BodyHandlers.ofString());

      String body = response.body();
      Document doc = Jsoup.parse(response.body());
      Element cbsBodyData = doc.getElementsByClass("data pinHeader").first();
      for(int x=1; x < 4; ++x) {

         Elements cbsDataRows = null;

         if(x != 3) {
            cbsDataRows = cbsBodyData.getElementsByClass("row" + x);
         }else{
            cbsDataRows = cbsBodyData.getElementsByClass("bgFan");
         }

         for (Element cbsDataRow : cbsDataRows) {

            Elements cbsTdDataRows = cbsDataRow.getElementsByTag("td");
            CbsPlayer cbsPlayer = new CbsPlayer();
            for (int y = 0; y < cbsTdDataRows.size(); ++y) {
               switch (y) {
                  case 1:
                     String name = cbsTdDataRows.get(y).getElementsByTag("span").first().html();
                     if (!name.contains("W (")) {
                        cbsPlayer.setOwner(cbsTdDataRows.get(y).getElementsByTag("span").first().attr("title").substring(12));
                     }
                     break;
                  case 2:
                     cbsPlayer.setName(cbsTdDataRows.get(y).getElementsByClass("playerLink").first().html());
                     if(cbsPlayer.getName().equals("Kris Bryant")){
                        System.out.println("stop here");
                     }
                     cbsPlayer.setTeam(cbsTdDataRows.get(y).getElementsByClass("playerPositionAndTeam").first().html().split(" ")[2]);
                     break;
                  case 3:
                     cbsPlayer.setPosition(cbsTdDataRows.get(y).html());
                     break;
                  case 4:
                     cbsPlayer.setSalary(cbsTdDataRows.get(y).html());
                     break;
                  case 5:
                     cbsPlayer.setContract(cbsTdDataRows.get(y).html());
                     break;
               }
            }
         }
      }
    }
}
