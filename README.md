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


# Modul 3 - Maintainability and OO Principles

## Reflection

1. SOLID principles yang telah diterapkan pada program salah satunya adalah Single Responsibility Principle. Sebelumnya, class ProductController memiliki 2 kegunaan, yaitu sebagai controller untuk model Product dan sebagai controller untuk model Car. Hal ini melanggar SRP karena class memiliki lebih dari 1 responsibilitas. Maka dibuatlah class CarController yang memiliki responsibilitas untuk mengambil data dari model Car. Lalu terdapat juga Liskov Substitution Principle, awalnya class CarController melakukan extend terhadap ProductController walaupun mereka menjalankan model yang berbeda sehingga tidak dapat melakukan substitusi dan overriding method yang di inherit. Maka pada class CarController yang baru, class tidak melakukan inheritance terhadap ProductController. Ada juga Dependency Inversion Principle yang telah diterapkan pada program. Sebelum diterapkan SOLID principles, CarController melakukan injection dengan concrete class CarServiceImpl yang mengimplement interface CarService. Maka setelah diterapkan SOLID principles, CarController melakukan injection dengan interface CarService.

2. Keuntungan menerapkan SOLID principles adalah dapat membuat program lebih terstruktur dan mudah dipelihara. Ketika kita ingin melakukan extensi atau penambahan fungsi maupun perubahan pada class, perubahan tersebut tidak akan menyebabkan error pada class lain. Pemisahan yang terstruktur juga berarti kita dapat melihat bagaimana class tersebut bekerja, dan mendapatkan informasi yang diperlukan untuk melakukan debugging maupun perbaikan. Contohnya, saat kita melakukan perubahan pada sebuah class, maka class yang lain tidak akan terpengaruh dan tidak mendapat resiko error. Misalkan juga saat kita ingin menambahkan fungsi pada class, kita tidak harus melakukan refactoring pada class lain.

3. Kerugian saat tidak menerapkan SOLID principles adalah kita harus melakukan refactoring pada class yang sudah ada jika ingin melakukan perubahan pada class tersebut. Hal ini dapat membuat program menjadi lebih banyak error dan membuat program menjadi lebih sulit dipelihara. Selain itu, class juga akan menjadi tidak terstruktur dan memiliki risiko terjadinya bug dengan interaksi antar class. Contoh kerugian salah satunya adalah saat kita melakukan perubahan pada class yang ada, maka kita terpaksa harus melakukan refactor penuh pada class tersebut. Selain itu, bisa saja interaksi antar class tersebut menghasilkan suatu error seperti sebuah class menghandle responsibilitas yang tidak sesuai yang seharusnya dilakukan oleh class lain. Lalu jika program tidak terstruktur, maka akan juga sulit untuk melakukan pemeliharaan, contohnya akan lebih sulit mencari letak suatu bug karena terdapat banyak fungsi yang diletakkan pada satu class.
