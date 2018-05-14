# Loading
Bu projedeki amaç edittext ile her farklı değerde butona basıldığında progressbar'daki değişimi göstermek.

---
Aşağıdaki eklentileri ekleyelim...

## build.gradle(Project:termometre)

![](https://thumbs.gfycat.com/ExaltedGranularGoral-small.gif)


allprojects {
    
    repositories {
    
        google()
        
        jcenter()
        
        maven{url 'https://jitpack.io'}

    }
}




## build.grade(Module:app)

implementation 'com.github.HotBitmapGG:RingProgressBar:V1.2.2'


![](https://thumbs.gfycat.com/ThoughtfulLazyBergerpicard-small.gif)


##
Kodları yazdıktan sonra sanal cihazda çalıştırmaya hazır olacaktır.
