
## TP5 — Character Manager Sprint #2

### 1. Fitur Baru

Pada tugas TP5 ini, program Character Manager dikembangkan dengan fitur-fitur berikut:

- `addCharacter()` untuk menambahkan karakter dan menolak nama duplikat.
- `findByName()` untuk mencari karakter berdasarkan nama.
- `removeCharacter()` untuk menghapus karakter berdasarkan nama.
- `getTotalCharacters()` untuk menghitung jumlah karakter.
- `getAllCharacters()` untuk mengembalikan salinan daftar karakter.
- `getAverageLevel()` untuk menghitung rata-rata level dan mengembalikan `0.0` jika daftar kosong.
- `findByType()` untuk mencari karakter berdasarkan tipe.
- `countByType()` sebagai fitur analitik tambahan untuk menghitung jumlah karakter berdasarkan tipe.

### 2. Screenshot Output CRUD

Pengujian CRUD dilakukan untuk membuktikan bahwa program dapat menambahkan karakter, mencari karakter, menghapus karakter, dan menolak penambahan nama duplikat.

![Screenshot Output CRUD](screenshots/crud.png)

### 3. Eksperimen Reference dan Defensive Copy

Eksperimen reference menunjukkan bahwa ketika variabel `b` dibuat menggunakan `Character b = a;`, kedua variabel menunjuk objek yang sama. Perubahan level melalui `b` juga memengaruhi nilai yang dibaca melalui `a`, dan ekspresi `a == b` menghasilkan `true`.

Untuk membuat objek independen, dibuat objek baru menggunakan constructor `new Character(...)`. Objek baru memiliki reference berbeda sehingga perubahan levelnya tidak otomatis mengubah objek awal.

Pengujian defensive copy menunjukkan bahwa menghapus isi daftar hasil `getAllCharacters()` tidak menghapus karakter dari daftar internal `CharacterManager`.

![Screenshot Eksperimen Reference]
(<Screenshot 2026-10-15 163346.png>)
(<Screenshot 2026-10-15 163522-1.png>)
(<Screenshot 2026-10-15 163535-1.png>)

### 4. Fitur Analitik Rancangan Sendiri

Fitur tambahan yang dibuat adalah `countByType(CharacterType type)`.

Method ini menghitung jumlah karakter berdasarkan tipe tertentu tanpa mengekspos `ArrayList` internal.

Contoh penggunaan:

```java
manager.countByType(CharacterType.WARRIOR);
```

Jika terdapat dua karakter bertipe `WARRIOR`, method mengembalikan nilai `2`.

Fitur ini memudahkan analisis jumlah karakter berdasarkan tipe. Method dilengkapi Javadoc dan menjaga enkapsulasi karena hanya mengembalikan hasil perhitungan, bukan daftar internal.

### 5. Google Docs — Analisis Bagian D

Analisis Bagian D membahas:
1. Perbedaan reference dan primitive value.
2. Alasan `totalCharacterCreated` menggunakan `static`.
3. Alasan `equals()` perlu di-override untuk memeriksa nama duplikat.
4. Risiko jika `getAllCharacters()` mengembalikan `ArrayList` asli.
5. Hubungan reference dengan defensive copy.

**Link Google Docs:** [Buka Analisis Bagian D](https://docs.google.com/document/d/1SSIexANsS156Lu-YPYz8dWmNxNgLhOr5TXCtoL8DPhk/edit?usp=sharing)


## TP8 — Implementasi GUI Character Manager

### 1. Hasil Implementasi

Aplikasi Character Manager dikembangkan menggunakan Java Swing. Jendela utama menampilkan daftar karakter secara dinamis, meliputi nama, tipe karakter, dan level. Aplikasi juga menampilkan statistik rata-rata level seluruh karakter yang dikelola oleh CharacterManager.

**Screenshot sebelum perubahan data:**

![alt text](image.png)

**Screenshot sesudah perubahan data:**

![alt text](image-1.png)

### 2. Aliran Data dan Prinsip MVC

Aliran data dimulai dari Main.java yang membuat objek CharacterManager dan menambahkan data karakter. CharacterManager menyimpan serta mengelola kumpulan karakter, sedangkan MainWindow mengambil data tersebut melalui method getAllCharacters() dan menampilkannya menggunakan JLabel dalam perulangan. MainWindow juga mengambil nilai rata-rata level dari CharacterManager untuk ditampilkan di bagian bawah daftar. Pembagian ini menerapkan prinsip MVC: Character dan CharacterManager berperan sebagai Model, MainWindow sebagai View, sedangkan Main menginisialisasi objek dan menghubungkan Model dengan View. Pada aplikasi yang lebih besar, pengendalian interaksi dapat dipisahkan ke Controller tersendiri.

### 3. Karakter Baru

- **Freya — MAGE, level 12:** dipilih untuk menambah variasi level pada tipe penyihir.
- **Aldric — HEALER, level 20:** dipilih untuk menambahkan tipe penyembuh dan memperluas variasi level karakter.

### 4. Statistik

Setelah kelima karakter ditambahkan, jumlah level adalah 65 dengan rata-rata 13,00. Nilai tersebut dihitung berdasarkan data karakter yang dikelola oleh CharacterManager, bukan ditulis secara tetap di GUI.

### 5. Dokumentasi Analisis

Link Google Docs Bagian D: [https://docs.google.com/document/d/1rtMcYTYg-kMUiohkacpK41TwihrFspRS_YsXwG5iSBs/edit?usp=sharing]


# TP10 - Character Manager

## Deskripsi

Character Manager adalah aplikasi desktop berbasis Java Swing yang digunakan untuk menampilkan data karakter dalam bentuk kartu. Proyek ini merupakan pengembangan antarmuka versi 0.4 dengan penerapan tema visual dan pemisahan tanggung jawab class.

## Tujuan

- Memahami penerapan OOP dalam aplikasi Java.
- Memisahkan pengelolaan data dan tampilan aplikasi.
- Menggunakan AppTheme untuk mengatur desain antarmuka.
- Menampilkan informasi karakter secara terstruktur.
- Menerapkan perbedaan tampilan berdasarkan role dan level karakter.

## Teknologi

- Java
- Java Swing
- Visual Studio Code
- Git dan GitHub

## Fitur Utama

- Menampilkan enam karakter.
- Menampilkan nama, role, dan level.
- Warna kartu berbeda berdasarkan role karakter.
- Level minimal 5 ditampilkan dengan warna emas dan font tebal.
- Menampilkan jumlah karakter.
- Menghitung rata-rata level karakter.
- Menampilkan informasi tambahan melalui tooltip.

## Struktur Program

```text
src/
└── com/
    └── unpri/
        └── charactermanager/
            ├── Main.java
            ├── model/
            │   ├── Character.java
            │   ├── CharacterManager.java
            │   └── CharacterType.java
            └── view/
                ├── AppTheme.java
                └── MainWindow.java
```

## Pengujian

Pengujian dilakukan untuk memastikan:

1. Aplikasi dapat dijalankan.
2. Seluruh karakter tampil dengan benar.
3. Warna kartu sesuai dengan role.
4. Level tinggi ditampilkan dengan penanda khusus.
5. Jumlah karakter dan rata-rata level dihitung dengan benar.

## Dokumentasi

**Screenshot sebelum perubahan**
![alt text](<Screenshot 2026-10-23 143614.png>)

**Screenshot sesudah perubahan**
![alt text](image-2.png)

## Google Docs
https://docs.google.com/document/d/1sAtDeQZZj2kVs94TOLaSVdip59FUTPXp7M2KCwu-RXQ/edit?usp=sharing


## Kesimpulan

Melalui proyek ini, konsep OOP dan pemisahan tanggung jawab diterapkan dalam pengembangan aplikasi Java Swing. Penggunaan AppTheme dan MainWindow membuat tampilan lebih konsisten, sedangkan CharacterManager membantu mengelola data karakter secara terpisah. Proyek ini dapat dikembangkan lebih lanjut dengan fitur pencarian, pengeditan, penghapusan, dan penyimpanan data karakter.


# Character Manager

Aplikasi desktop Java Swing untuk mengelola dan menampilkan
karakter dengan konsep Object-Oriented Programming dan MVC.

## Teknologi

- Java
- Java Swing
- VS Code
- Git dan GitHub

## Struktur Project

```text
src/
└── com/unpri/charactermanager/
    ├── Main.java
    ├── model/
    │   ├── Character.java
    │   ├── CharacterType.java
    │   └── CharacterManager.java
    └── view/
        ├── AppTheme.java
        └── MainWindow.java
```

# TP12 - MainWindow v0.5
## A. Implementasi Layout

Pada TP12, aplikasi Character Manager dikembangkan
menggunakan BorderLayout dengan empat wilayah utama.

1. NORTH: Header dan panel statistik.
2. CENTER: Daftar karakter menggunakan JScrollPane.
3. EAST: Legenda role karakter.
4. SOUTH: Bar status dan versi aplikasi.

Legenda menggunakan BoxLayout dengan arah Y_AXIS.
Daftar karakter menggunakan GridLayout pada panel
pembungkus yang dimasukkan ke JScrollPane.

## B. Wireframe

```text
+------------------------------------------------------+
|                    HEADER (NORTH)                    |
|                 CHARACTER MANAGER                    |
|  Total Karakter | Rata-rata | Jenis Role | Version   |
+--------------------------------------+---------------+
|                                      |               |
|             CHARACTER LIST          |    LEGENDA    |
|                                      |               |
|    +----------------+                |   WARRIOR     |
|    | Arka           |                |               |
|    +----------------+                |   MAGE        |
|    +----------------+                |               |
|    | Luna           |                |   ARCHER      |
|    +----------------+                |               |
|                                      |               |
|             SCROLL PANE              |               |
+--------------------------------------+---------------+
| STATUS BAR                | v0.5                     |
+------------------------------------------------------+
```

## C. Screenshot Pengujian

### 1. Ukuran Awal

![Screenshot ukuran awal](![alt text](awal.png))

### 2. Jendela Dilebarkan

![Screenshot jendela lebar](![alt text](lebar.png))

### 3. Jendela Dikecilkan

![Screenshot jendela kecil](![alt text](kecil.png))

## D. Tabel Pengamatan Resize

| Pengujian | Prediksi | Hasil Pengamatan |
|---|---|---|
| Ukuran awal | Semua wilayah terlihat | Isi aplikasi terlihat |
| Jendela dilebarkan | Area CENTER bertambah luas | Kartu memperoleh ruang lebih luas |
| Jendela dikecilkan | Scrollbar muncul jika konten tidak muat | Daftar tetap dapat digulir |

## E. Struktur Panel Bersarang

Aplikasi menggunakan JFrame sebagai jendela utama
dengan BorderLayout sebagai pengatur wilayah.

Panel header memiliki panel statistik tambahan
yang menggunakan GridLayout 2x2.

Panel daftar karakter memiliki panel pembungkus
yang berisi kartu karakter dengan GridLayout.
Panel pembungkus tersebut dimasukkan ke JScrollPane.

Panel legenda menggunakan BoxLayout Y_AXIS,
sedangkan status bar menggunakan BorderLayout.

## F. Alasan Pemilihan Layout

BorderLayout dipilih karena dapat membagi jendela
menjadi empat wilayah dengan fungsi berbeda.

GridLayout dipilih untuk menyusun kartu karakter
dalam dua kolom dengan ukuran sel seragam.
GridLayout juga dipilih untuk panel statistik karena
empat informasi perlu disusun dalam bentuk 2x2.

BoxLayout Y_AXIS dipilih untuk legenda karena setiap
jenis role ditampilkan secara vertikal.

FlowLayout tidak dipilih sebagai layout utama kartu
karena tidak menyediakan susunan kolom tetap.
GridBagLayout juga tidak dipilih karena lebih kompleks
daripada kebutuhan tampilan aplikasi ini.

## G. Panel Tambahan

Panel statistik ditambahkan di bawah judul header.
Panel tersebut menampilkan total karakter, rata-rata
level, jumlah jenis role, dan versi layout.

GridLayout 2x2 dipilih agar informasi tersusun rapi
dan memiliki ukuran komponen yang seragam.

## H. Google Docs - Analisis Layout dan MVC

[https://docs.google.com/document/d/1wzwY4Nb6lGt1-lEcdQkpbOorD-w5GN2o1tenkKQa2E8/edit?usp=sharing]

## I. Kesimpulan

Pada TP12, aplikasi Character Manager menggunakan
Layout Manager agar tampilannya dapat menyesuaikan
ukuran jendela.

Penggunaan BorderLayout, GridLayout, BoxLayout,
dan JScrollPane membuat susunan komponen lebih teratur.
Pengujian resize dilakukan dalam tiga ukuran jendela
untuk mengamati perubahan tampilan aplikasi.


# TP14 — Form & Input Validation

## A. Implementasi Form

TP14 mengembangkan aplikasi Character Manager dengan
menambahkan CharacterFormPanel.

Komponen yang digunakan:

- JTextField untuk memasukkan nama karakter.
- JComboBox untuk memilih role karakter.
- JSpinner untuk memasukkan level 1–99.
- JLabel untuk menampilkan pesan validasi.

Validasi nama dilakukan secara berurutan:
1. Kelengkapan nama.
2. Panjang nama maksimal 20 karakter.
3. Format nama.
4. Keunikan nama.

Input nama dibersihkan menggunakan trim().

## B. Validasi Model

Model memiliki tanggung jawab menjaga aturan bisnis.

Aturan yang diterapkan:

1. Nama tidak boleh kosong.
2. Nama maksimal 20 karakter.
3. Role tidak boleh null.
4. Level harus 1–99.
5. MAGE tidak boleh memiliki level di atas 60.

CharacterManager juga menerapkan:
- Nama karakter harus unik.
- Jumlah karakter maksimal 20.
- getAllCharacters() mengembalikan salinan daftar.

## C. Validasi Tambahan

| Aturan | Lapisan | Alasan |
|---|---|---|
| Tidak boleh ada spasi ganda | View | Meningkatkan kualitas input pengguna |
| Maksimal 20 karakter dalam daftar | Model/Manager | Melindungi data dari semua sumber input |

## D. Tabel Pengujian

| No | Input | Hasil Diharapkan | Hasil Nyata | Lapisan |
|---|---|---|---|---|
| 1 | Nama kosong | Pesan nama wajib diisi | Isi setelah tes | View |
| 2 | Nama Regnar (duplikat) | Nama sudah digunakan | Isi setelah tes | View |
| 3 | Nama dengan angka | Format ditolak | Isi setelah tes | View |
| 4 | Nama dengan spasi ganda | Format ditolak | Isi setelah tes | View |
| 5 | Nama lebih dari 20 karakter | Ditolak | Isi setelah tes | View |
| 6 | MAGE level 61 | Ditolak | Isi setelah tes | Model |
| 7 | WARRIOR level 99 | Berhasil ditambahkan | Isi setelah tes | Model |
| 8 | Level 100 | Ditolak | Isi setelah tes | Model |
| 9 | Role null | Ditolak | Isi setelah tes | Model |
| 10 | Karakter ke-21 | Ditolak | Isi setelah tes | Manager |

Catatan:
Hasil nyata diisi berdasarkan pengujian langsung aplikasi.
Jika berbeda dari hasil yang diharapkan, periksa pesan error,
perbaiki kode pada lapisan yang bertanggung jawab,
kemudian ulangi pengujian.

## E. Screenshot

### 1. Error Nama Kosong
[![alt text](<Screenshot 2026-11-19 154944.png>)]

### 2. Error Nama Duplikat
[![alt text](<Screenshot 2026-11-19 155055.png>)]

### 3. Sukses Menambahkan Karakter
[![alt text](<Screenshot 2026-11-19 155207.png>)]

## F. Kompromi Sementara

Pada sprint ini, ActionListener masih digunakan
dengan implementasi minimal untuk menangani tombol tambah.
View juga memanggil CharacterManager secara langsung
agar proses penambahan karakter dapat berjalan dengan sederhana.
Pendekatan ini mempermudah integrasi awal, tetapi membuat
ketergantungan antara View dan Manager masih cukup kuat.
Pada pertemuan berikutnya, pemisahan tanggung jawab
diharapkan membuat struktur aplikasi lebih terorganisasi.

## G. Analisis Input dan Validasi

Dokumen Google Docs:
[https://docs.google.com/document/d/116-XuhTapk8TRVS2xb-AXA_aJhApW_YuGQIhQ7DpDDA/edit?usp=sharing]


