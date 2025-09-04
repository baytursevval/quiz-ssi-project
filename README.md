# Quiz-SSI Project 

## Proje Hakkında
Quiz-SSI, mikroservis mimarisi üzerine geliştirilmiş bir quiz uygulamasıdır.  
Bu proje, kimlik doğrulama kısmında **Blockchain tabanlı Self-Sovereign Identity (SSI)** yaklaşımı kullanır.  
Kullanıcıların kimlik bilgileri merkezi bir veritabanında saklanmaz, yalnızca hash değerleri Blockchain'e kaydedilir.  
Böylece merkeziyetsiz, güvenli ve şeffaf bir kimlik doğrulama sistemi sağlanır.

## Mimari
Proje aşağıdaki mikroservislerden oluşmaktadır:

- **Auth Service** → Kullanıcı kayıt ve login işlemleri.  
  - Kullanıcı bilgileri SHA-256 ile hash’lenir.  
  - Hash Blockchain’e kaydedilir.  
  - Login sonrası JWT üretilir.  
- **Quiz Service** → Quiz oluşturma ve listeleme.  
- **Question Service** → Soruların yönetimi.  
- **API Gateway** → Tüm istekler buradan geçer, JWT kontrolü yapılır.  
- **Service Registry (Eureka)** → Servislerin bulunabilirliği sağlanır.  

## Blockchain Entegrasyonu ('quiz-blockchain' file)
- **Ganache** ile local Ethereum ağı kullanıldı.  
- **Truffle** ile akıllı kontrat geliştirildi ve deploy edildi.  
- Akıllı kontrat: `UserRegistry.sol`  
  - Kullanıcıların hash değerleri kaydedilir ve doğrulanır.  
- **Web3j** kütüphanesi ile Java servisleri Blockchain ile konuşturuldu.

## 🛠️ Kullanılan Teknolojiler
- **Java 21** + **Spring Boot**
- **Spring Cloud Netflix (Eureka, Gateway, Feign)**
- **Docker** (mikroservislerin containerize edilmesi için)
- **Blockchain** → Ethereum, Ganache, Truffle
- **Web3j** → Blockchain ile Java entegrasyonu
- **JWT (JSON Web Token)** → Kimlik doğrulama
- **PostgreSQL / MySQL** (isteğe bağlı, quiz ve sorular için)

## 🚀 Çalıştırma Adımları
1. **Blockchain Ağı Kurulumu**
   - Ganache’i başlat
   - `truffle migrate` komutu ile kontratı deploy et
   - Contract address’i `application.yml` dosyasında güncelle

2. **Mikroservislerin Çalıştırılması**
   - `mvn clean install` ile tüm projeyi build et
   - Her servisi ayrı ayrı çalıştır veya Docker Compose ile ayağa kaldır

3. **Kayıt ve Login**
   - `POST /auth/register` → Kullanıcı kaydı (hash Blockchain’e yazılır)
   - `POST /auth/login` → Kullanıcı login olur ve JWT alır

4. **Quiz ve Question İşlemleri**
   - `Authorization: Bearer <token>` header’ı ile quiz ve question endpoint’lerine erişilir

