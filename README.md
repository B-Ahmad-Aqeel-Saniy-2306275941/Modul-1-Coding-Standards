# Modul 1 - Coding Standards

## Reflection 1

Dalam tutorial modul 1 ini, saya belajar mengenai clean code dan coding standards. Kode yang dibuat dalam aplikasi tersebut memiliki format yang konsisten sehingga mudah untuk dibaca. Penamaan function dan variabel juga dibuat agar dapat dipahami tanpa menjelaskan function tersebut. Penamaan variabel dan file name dibuat secara konsisten. Melihat kode saya sendiri, dapat dilihat bahwa terdapat bagian kode yang dapat bermasalah jika aplikasi didevelop dengan skala yang lebih besar.


## Reflection 2

1. Jika sebuah kode memiliki 100% Code Coverage, bukan berarti kode tersebut akan bebas dari bugs dan error. Code Coverage hanya mencakup berapa banyak fungsionalitas kode yang di test, sehingga walaupun kita telah membuat unit test yang memiliki code coverage sebesar 100%, bisa saja tetap ada bug misalnya dengan logic error atau edge cases. Maka dari itu 100% code coverage bukan berarti kode bebas dari bugs dan errors.

2. Jika membuat functional test dengan setup yang sama, maka akan banyak terdapat duplicate code. Hal ini dapat membuat program mengulangi task yang sama untuk test class tersebut sehingga tidak berjalan secara efektif. Implementasi functional test yang sekarang tidak terlalu bersifat scalability, sehingga saat menambahkan test yang lain, kode akan menjadi berantakan yang berpotensi membuat bugs dan error. Hal yang dapat diimprovisasi adalah dengan melakukan setup pada satu tempat sehingga program tidak perlu menjalankan kode yang sama, selain itu dapat juga menggunakan variabel atau helper function yang dapat digunakan beberapa kali dalam beberapa test yang berbeda sehingga tidak perlu menjalankan seluruh setup kembali.


# Modul 2 - CI/CD

## Reflection

1. Kode yang diperbaiki dalam modul 2 ini terdapat pada bagian Product Repository. Saya mengubah beberapa variabel sehingga lebih jelas kegunaannya pada kode tersebut. Pada modul 1 saya menjelaskan kekurangan kode yang ada adalah pada bagian product_id. Hal itu dikarenakan pada modul 1, product_id awalnya menggunakan custom id yang berupa seperti index pada database, hal ini dapat membuat masalah jika database berkembang semakin besar. Maka dari itu, product_id saya ubah menggunakan UUID yang kemudian diubah menjadi bentuk string.

2. Ya, implementasi saat ini sudah mencukupi definisi CI/CD. Untuk bagian CI, terdapat automated testing yang dijalankan setiap kali ada perubahan pada kode. Kemudian juga kita dapat melihat hasil dari test yang telah dijalankan pada branch yang telah dibuat. Untuk bagian CD, terdapat deployment otomatis pada program sehingga setiap kali dilakukan push ke branch utama, akan terjadi deployment secara otomatis.
