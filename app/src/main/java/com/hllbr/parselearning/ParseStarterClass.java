package com.hllbr.parselearning;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        /*Logcat içerisinde istediğim işlemleri belirtebilir bunlara geri dönüşler abailirim.Örneğin
        Sadece hatalarda haber veremesi için log_level_debug
        log_level_verbose herşeyi göster
        log_level_warning uyarıları göster
        log_level_debug debug yaparken göster gibi birini yazıp logcat içerisinde yazılacak logları belirleyebiliyorum
        Bunlar çok gerekli değil ama sounlu bir durumda kullanılması gerekebilir.
        Ben sadece debug yazdırmak istediğim için böyle ibir seçim yapıyorum


         */

        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("bxaF7cb6zXk46Jc6mZYo5oU2KnTmrClveQATHwDU")
        .clientKey("Io3FyPoTZN7teWU1L7C5BONLxmIPqpsZYqcjkL7H")
        .server("https://parseapi.back4app.com/")
        .build()
        );//Burada yapacağım işlemle birlikte initialize tanımlama işlemim sonlanmış olacak
        //Parse kendi configurasyon objesi var.
        //gerekli bilgileri gidriğimde parse ile ilgili tüm işlemlerimi bitirmiş oluyorum
        //Parse bir servis olduğu için arkaplanda backend işlemleri hallediyor fakat burada işleyeceğim veriler kaytdedeceğim fotoğrafların hepsi online bir server da (sunucuda) tutulacak
        //bizim sunucumuzda ise appId ,istemci anahtarı, sunucu bilgilerini Parse verelim ve bu şekilde proje ile internetteki serveri bağlayabilelim.
        //bu kısmı firebase içerisinde hazır bir json dosyası indirerek yapmıştım
        //hazır dosya içerisinde bağlantı için gerekli ayarlar mevcuttur.Google server kullanıldığı için invade edilmiş halde geliyordu

    }
}
