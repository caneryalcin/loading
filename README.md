# Loading
Bu projedeki amaç edittext ile her farklı değerde butona basıldığında progressbar'daki değişimi göstermek.

---
Aşağıdaki eklentileri ekleyelim...

## build.gradle(Project:termometre)

allprojects {
    
    repositories {
    
        google()
        
        jcenter()
        
        maven{url 'https://jitpack.io'}

    }
}

![](https://thumbs.gfycat.com/ExaltedGranularGoral-small.gif)

## build.grade(Module:app)
implementation 'com.github.HotBitmapGG:RingProgressBar:V1.2.2'

##
Kodları yazdıktan sonra sanal cihazda çalıştırmaya hazır olacaktır.
