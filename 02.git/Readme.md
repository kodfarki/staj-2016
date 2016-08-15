#Konsol Git Kullanım Rehberi

Git Kurulumu yapılır ve git içerisinde "Git Bash" adlı konsol uygulaması çalıştırılır. Tüm işlemler bu konsol içerisinde komutlar ile yürütülür.

##1. Adım
Öncelikli olarak kimlik tanımlaması yapılmalıdır. O'da Şu şekildedir;
```
 git config --global user.name "MZG"
 git config --global user.email mzg@zahit.net
```
## 2. Adım

 Komutu kullanılarak bulunan dizin bir git repository hailine getirilir ve .git adında bir dizin oluşturur.
```git
git init
```
## 3. Adım
Bu komut kullanılarak mevcut oluşturulan dosyaları commit etmeye  hazır hale getirir. Bu komut kullanılması zonludur.Hani dosyaların commit edilip edilmeyeceği bu aşamada karar verilir.
```
git add .
git add  file1.txt
```
'git add .' bu  komut tüm dosyaların gönderieceği anlamına gelir.

## 4. Adım
 Bu komut sadece doslyarımızın ne durumda olduğunu gösterir.Eğer kırmızı renk ile gösterilmişse bunların henüz add işlemi yapılmadını yanı commit yapıldığı zaman remote gönderilmeyeceği  anlamına gelir.Eğer yeşil ise herhangi bir problemin olmadı ve commit atıldığı zaman remoteye gonderilmeye hazır olduğu anlaşılır
```
git status
```

Bu komut yerel bilgisayarimiz ile server bilgisayari arasindaki kod farkliliklarindan bizi haberdar eder. git status komutunu calistirdiktan sonra ’new, modified, deleted, merge’ gibi etiketler ile dosya isimleri siralanir. Etiket isimlerinden de dosyalarin ne tur dosyalar oldugu aciktir. Yeni dosya, degistirilmis dosya, silinmis dosya veya birlestirilecek dosya. [alıntı]

## 5.Adım

```
git commit -m "initial commit"
```
Bu komut ile yapılan değişiklikleri tırnak içerisine açıklama girerek commit atmaya yarar.Local de commit atılarak değişikliklerin kaydedilmesini sağlar.Tüm yapılan işlemler sadece local üzerinde çalışır.

## 6. Adım
```
$ git log
```
Yapılan tüm commitlerin,loglarını gösterir

```
$ git log --graph
```
Yapılan commitleri kim trafından yapıldığı bilgisiyle gösterir

```
git log --graph --oneline
```
Yapılan commitlerin sadece adını ve numarsını listeler.

```
$ git log --graph --oneline --decorate
```
Yapılan commitlerin hangi branche bağlı olduğunu gösterir.

## 7.Adım

```
git remote add origin git@github.com:kodfarki/staj-2016.git
```

Yapılan commitleri remote deki repositorye kaydetmeyi sağlayan komuttur. Aynı şekilde hangi repoya kayıt edileceği link ile belirtilmesi gerekmektedir.

## Git Push
```
git push 
```
Commitleri remote ye göndermek için kullanılır. Eğer sonuna branc ismi yazılmaz ise varsayılan olarak master brancine gönderilir.
```
git push origin master
```
## Git Pull
```
git pull
```
Bu komut ile remote daki tüm değişiklikleri local bigisayarınaza indirir

## Git Fetch
```
git fetch
```
Fetch işlemi remote deki tüm bilgileri locale indirir ama localdeki doslyalar ile birleştirmez. Birleştirebilmek;
```
git merge
```
komutu kullanılır. 

## Git Clone
```
git clone https://github.com/kodfarki/staj-2016.git
```
Github üzerindeki repositoryi tamamıyla bilgisayara indirmeye yarar.

## Git Stash
```
git stash
```
Bu komut ile commitlerinizi geri alıp bekletip daha sonra tekrardan işleme sokabilirsiniz.Genellikle merge işlemlerinde doğan sorunları önlemek için kullanılabilmektedir.Stashe atılan commitleri tekrar geri getirilip kullanılabilir
```
git stash pop
```
Stashe atılan bilgilerin geri alınmasını sağlar

