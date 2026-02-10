# Modul 1 - Coding Standards

## Reflection 1

Dalam tutorial modul 1 ini, saya belajar mengenai clean code dan coding standards. Kode yang dibuat dalam aplikasi tersebut memiliki format yang konsisten sehingga mudah untuk dibaca. Penamaan function dan variabel juga dibuat agar dapat dipahami tanpa menjelaskan function tersebut. Penamaan variabel dan file name dibuat secara konsisten. Melihat kode saya sendiri, dapat dilihat bahwa terdapat bagian kode yang dapat bermasalah jika aplikasi didevelop dengan skala yang lebih besar.


## Reflection 2

1. Jika sebuah kode memiliki 100% Code Coverage, bukan berarti kode tersebut akan bebas dari bugs dan error. Code Coverage hanya mencakup berapa banyak fungsionalitas kode yang di test, sehingga walaupun kita telah membuat unit test yang memiliki code coverage sebesar 100%, bisa saja tetap ada bug misalnya dengan logic error atau edge cases. Maka dari itu 100% code coverage bukan berarti kode bebas dari bugs dan errors.

2. Jika membuat functional test dengan setup yang sama, maka akan banyak terdapat duplicate code. Hal ini dapat membuat program mengulangi task yang sama untuk test class tersebut sehingga tidak berjalan secara efektif. Implementasi functional test yang sekarang tidak terlalu bersifat scalability, sehingga saat menambahkan test yang lain, kode akan menjadi berantakan yang berpotensi membuat bugs dan error. Hal yang dapat diimprovisasi adalah dengan melakukan setup pada satu tempat sehingga program tidak perlu menjalankan kode yang sama, selain itu dapat juga menggunakan variabel atau helper function yang dapat digunakan beberapa kali dalam beberapa test yang berbeda sehingga tidak perlu menjalankan seluruh setup kembali.
