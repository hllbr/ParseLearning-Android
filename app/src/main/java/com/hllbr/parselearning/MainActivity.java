package com.hllbr.parselearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Parse nasıl veri yazılır nasıl veri çekilir ?

        Parse ile ibr obje oluşturmak için ParseObject kullanılır.Veritabanına veri yazacağımız Twitter üzerinden twetlerini kaydedeceğiz kullanıcımızın yada dietisyen uygulaması yapıyoruz yemekleri ve kalorilerileri internet üzerinden kaydetmek istedik bunun ve buna benzer durumların belirli sebeplerin ardından geldiğini gelebildiğini bilmek gerekiyor veriyi static oalrakta kaydedebilirdik fakat internet üzeinde tutarak farklı kazançlar/esneklikler elde edebilir duruma geliyoruz.
        Uygulamaların çoğu internette bir sunucuyla çalışıyor.*/

       /* ParseObject object = new ParseObject("Fruits");
        object.put("name","banana");//buradaki put methodu bize bir değer ve bir anahtar ile birlikte çalışıyor.Hashmap gibi
        object.put("calories",150);*/
        /*buradaki verilerimi server'a kaydederek b ir deneme yapmaya çalışıyorum.Henüz bağlantıyı kontrol etmedik.grandle ayarlamaları manifest içerisinde gerekli bilgilerin girilmesine rağmen henüz bağlantı testi gerçekleştirmedik
        obje ile kaydetmek için bir çok seçenek çıkıyor.saveInBackGround = arka planda kaydet ,save o an kaydetmeye çalışıyor, her zaman saveInBackGround kullanmamız gerekiyor.
        Fakat SaveInBackgroun için bir callback veren ve vermeyen oalrak iki farklı kullanımı mevcut .Callback alabildiğimize işlemin başarılı veya beşarısız olması durumunda ne yapcağımızı yazabiliyoruz.
        Her zaman saveInBackgrounf(Callback) olanı kullanmamız daha iyi bir seçenek .(zorunluluk derecesinde bir istek )
        */

        //Veri Kayıt (Yazma)=
        /*
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {


                if(e != null){
                    //exception ifadem Eğer boş değilse yani hata mevcut ise bu hatanın mesajını kullanıcıya bildirmek istiyorum bu uygulama içni böyle bir çözüm tekniği kullanıcam
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }else{//eğer bir hata yoksa yapılacaklar =
                    Toast.makeText(getApplicationContext(),"Done !",Toast.LENGTH_LONG).show();
                }

            }
        });
        */
          /*    Yukarıdaki işlem satırları için =
            İşlem bittikten sonra bana ParseException veren bir yer var yeni hata
            burada hata değerimin boş olup olmadığını kontrol ederek sonucu değerlendirmem ve gerekli tanımlama ve emirleri yazdırmam gerekiyor.
        */
        /*
        verileri yazdıktan sonra okumak gerekiyor ve okuma işleminin birden fazla yolu bulunuyor .Filtreyererek de okuyabilir.
        ParseQuery ile bir okuma işlemi yapıcam ve bir parseobject çekeceğim için alt satırdaki tanımlamayı yapıyorum
         */

       // ParseQuery<ParseObject> query = ParseQuery.getQuery("Fruits");//Çekme işlemini Bu sınıftan (Dosyadan) yapcağımı belirtiyorum.
        /*Veri çekme işlemini serverlarda ,SQL,SQLite ,Firebase ... olduğu gibi querylerle yapıyorum
        bunu çekmenin bir kaç youl mevcut =
        query.findInBackground();//arkaplanda bul bunun içinde callback olan ve olmayan seçenekler mevcut
        query.countInBackground() arkaplanda say tabi bununda callback olan ve olmayan versionları var
        her veriyi çekmeme gerek yok kaç adet veri(Object) olduğunun değerinide döndürebilirim.
        query.getFirst() ilk objeyi getir
        query.getInBackground()arkaplandan al....

        */
        /*
        Alt satırda bulunnana yapı ile ilgili olarak bunları eğer object id ile işlemler yapıyorsan örnek olarak
        serverdan sadece object id ler çekerek bunları bir diziye atabilir.Objeye tıklandığında objeye ait herşeyi çekebilirsin ...
         */
       /* query.getInBackground("wRgbn22K4O", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                //bu yapı yazma işleminden farklı olarak bide parseObject veriyor.
                if(e != null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"read operation OK!",Toast.LENGTH_LONG).show();
                    //Objeyi alma işlemlerim için =
                    String objectName = object.getString("name");//dosya içerisine hangi isimle kaydettiysem aynı şekilde ifade ediyorum
                    int calories = object.getInt("calories");
                    Date date = object.getCreatedAt();
                    System.out.println("Object Name : " +objectName);
                    System.out.println("Object calori : "+calories);
                    System.out.println("object data : "+date);
                }
            }
        });
        bu yapı bizden objectId istiyor.Bu parse tarafından atanan random ıdlerdir.Projelerde kullandığım unic ıdler gibi idler atıyor Parse
        */

    //Tüm objeleri çekebilmekte mümkün şimdi bu verileri çekeceğim =

     ParseQuery<ParseObject> query = ParseQuery.getQuery("Fruits");
     //bu sefer getInBackgroun değil findInBackground diyorum bir önceki işlemimden farklı olarak

       /* query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                //Bu sefer bana bir obje değil list of objects veriyor yani pars objeleri listesi çekiyorum bu yapıyla birlikte
                //Diğer yapılarımda da olduğu gibi bir hata sorgulaması için exception objeside veriyor
                if(e != null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"operation of full read OK!",Toast.LENGTH_LONG).show();
                    //hata alınmadığı durumda object dizimle işlemlerimi bu alanda gerçekleştiriyorum .Burda önce obje listemin dolu olup olmadığını kontrol etmeliyim ardından bu liste eğer dolu ise işlemlerime devam etmeliyim.
                    if(objects.size()>0){
                        //dizim dolu mu ? yoksa boş bir query(kuytukla) mı işlem yapmaya çalışıyorum ?
                        for(ParseObject object : objects){
                            //burad işlemi tek bir obje haline indirgemiş oldum .Bunu tüm sınıftaki objeler için yapcıam
                            String objcetName = object.getString("name");
                            int objectCalories = object.getInt("calories");
                            Date date = object.getCreatedAt();
                            String objectId = object.getObjectId();

                            System.out.println("Object Name :"+objcetName);
                            System.out.println("Object Calorie :"+objectCalories);
                            System.out.println("Object DATE :"+date);
                            System.out.println("Object ID :"+objectId);

                        }
                    }
                }
            }
        });*/
        //Eğer sadece banana verisiyle ilgili verileri almak istesetdim ve objectıd bilmiyor olsaydım  =
       // query.whereEqualTo("name","banana")//sqlite da olduğu gibi birşey birşeye eşitse çek şeklinde kullanılarak filtreli şekilde işlemlerimi yapabilirim...
       /* query.whereEqualTo("name","banana");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e != null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }else{
                    if(objects.size() >0){
                        for(ParseObject object:objects){
                            //this is a for loop
                            String objcetName = object.getString("name");
                            int objectCalories = object.getInt("calories");
                            Date date = object.getCreatedAt();
                            String objectId = object.getObjectId();

                            System.out.println("Object Name :"+objcetName);
                            System.out.println("Object Calorie :"+objectCalories);
                            System.out.println("Object DATE :"+date);
                            System.out.println("Object ID :"+objectId);
                        }
                    }
                }
            }
        });*/


        //query.whereGreaterThan()büyükleri filtrelemek için kullanabilirim.
/*
        query.whereLessThan("calories",130);//küçükleri filtrelemek için kullanıyorum.Kalori değeri 130 dan küçük olan değerlerle ilgili verileri çekiyorum

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e != null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

                }else{

                    Toast.makeText(getApplicationContext(),"operation Done!",Toast.LENGTH_LONG).show();
                    for(ParseObject object :objects){
                        //for-loop of storing operation
                        String objcetName = object.getString("name");
                        int objectCalories = object.getInt("calories");
                        Date date = object.getCreatedAt();
                        String objectId = object.getObjectId();

                        System.out.println("Object Name :"+objcetName);
                        System.out.println("Object Calorie :"+objectCalories);
                        System.out.println("Object DATE :"+date);
                        System.out.println("Object ID :"+objectId);
                    }

                }
            }
        });*/




        //Kullanıcı oluştuma işlemleri =



        //Parse içerisinde user adlı hazır bir sınıf var fakat henüz bir işlem gerçekleştirmediğim için bu alan boş .Parse üzerinde kullanıcı işlemleri yapmak için parseUser olarak tanımlanmış bir sınıf mevcut ....

       /* ParseUser parseUser = new ParseUser();

        //Oluşturduğum kullanıcı objesine en azından default olarak kullanıcı ismi ve parola verebiliyorum
        //projemi gerçekleştirirken bunları giriş ekranında kontrol edeceğim fakat suan bu işlemi manuel olarak bu alanda gerçekleştirmem gerekiyor.

        parseUser.setUsername("hllbr");
        parseUser.setPassword("123456");
        //parseUser.signUp();
        //parseUser.signUpInBackground();
        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

                }else{

                    Toast.makeText(getApplicationContext(),"good job(User Signed Up)",Toast.LENGTH_LONG).show();

                }
            }
        });*/
        //Kullanıcı ile giriş yapma işlemleri çok basittir.

        //ParseUser.logIn()
        ParseUser.logInInBackground("hllbr", "123456", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Welcome "+user.getUsername()+" well program",Toast.LENGTH_LONG).show();
                    //Eğer giriş işlemi başarılı olursa alabileceğim bazı veriler var.

                    System.out.println("welcome : "+user.getUsername().toString());


                }
            }
        });
    }
}