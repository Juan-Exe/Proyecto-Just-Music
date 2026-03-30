<div align="center">

# Just Music

**Aplicación de escritorio de streaming de música desarrollada en Java con JavaFX**

*Proyecto académico de portafolio — inspirado en Tidal y Spotify*

![Java](https://img.shields.io/badge/Java-8-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-incluido_en_JDK_8-007ACC?style=for-the-badge&logo=java&logoColor=white)
![FXML](https://img.shields.io/badge/FXML-MVC-6DB33F?style=for-the-badge)
![CSS](https://img.shields.io/badge/CSS-JavaFX-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-IDE-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
![Launch4j](https://img.shields.io/badge/Launch4j-exe_packaging-FF6600?style=for-the-badge)

</div>

---

## Descripcion

Just Music es una aplicacion de escritorio que simula la experiencia de una plataforma de streaming musical moderna. Permite explorar albumes, reproducir canciones y navegar por una biblioteca musical con una interfaz fluida y estilizada.

El proyecto demuestra el uso del patron **MVC**, manejo de **multimedia en Java** con la API `MediaPlayer` de JavaFX, diseno de **interfaces declarativas con FXML**, estilos con **CSS de JavaFX**, y gestion de multiples vistas y controladores interconectados.

---

## Funcionalidades

| Funcionalidad | Descripcion |
|---|---|
| Reproduccion | Play, pausa, siguiente, anterior con sincronizacion de icono |
| Modo aleatorio | Shuffle entre canciones del album activo |
| Modo bucle | Repeticion continua del album |
| Barra de progreso | Slider interactivo sincronizado en tiempo real con la cancion |
| Control de volumen | Slider de volumen conectado al MediaPlayer activo |
| Lista de canciones | Lista scrollable con efecto hover por album |
| Mini-player | Portada, nombre de cancion y album en la barra superior |
| Dos tipos de usuario | Oyente y Artista con vistas y experiencias independientes |
| Autenticacion | Login y registro sin base de datos externa (usuarios hardcodeados) |

---

## Arquitectura

```
src/
├── controller/
│   ├── viewExampleController.java       # Vista principal modo invitado
│   ├── viewExampleController_1.java     # Vista principal modo oyente
│   ├── AlbumController.java             # Interfaz comun de controladores de album
│   ├── [Album]_Controller.java          # Controlador por cada album
│   └── ...
├── model/
│   ├── DBUtils.java                     # Autenticacion de oyentes
│   └── DBUtils_Artista.java             # Autenticacion de artistas
└── view/
    ├── viewExampleController.fxml       # Vista principal
    ├── [Album].fxml                     # Vista por album
    ├── scrollbar.css                    # Scrollbar personalizada
    └── ...
```

**Patron de comunicacion:** Cada controlador de album recibe una referencia al controlador principal (`setMainController`) y actualiza etiquetas, barra de progreso e icono de reproduccion directamente sobre el a traves de metodos publicos como `setPlayIcon()`, `setSongLabel()`, `updateProgressBar()`.

---

## Tecnologias

| Tecnologia | Version | Uso en el proyecto |
|---|---|---|
| Java | 8 (Oracle JDK 1.8.0_202) | Lenguaje principal — unico JDK con JavaFX incluido |
| JavaFX | Incluido en JDK 8 | Framework de interfaz grafica de escritorio |
| FXML | JavaFX 21 schema | Diseno declarativo de vistas, separado del controlador |
| CSS (JavaFX) | — | Scrollbar personalizada, efectos hover, paleta de colores |
| MediaPlayer API | JavaFX | Reproduccion de MP3, control de progreso y volumen |
| Patron MVC | — | Separacion estricta de modelo, vista y controlador |
| Launch4j | 3.x | Empaquetado del JAR como ejecutable `.exe` con JRE incluido |
| NetBeans IDE | — | Entorno de desarrollo principal |

---

## Usuarios de prueba

La aplicacion usa autenticacion con usuarios preconfigurados (sin base de datos externa).

### Oyente
| Correo | Contrasena |
|--------|-----------|
| `oyente@justmusic.com` | `oyente123` |
| `demo@justmusic.com` | `demo123` |

### Artista
| Correo | Contrasena |
|--------|-----------|
| `artista@justmusic.com` | `artista123` |
| `scoot@justmusic.com` | `scoot123` |

> Tambien puedes registrar un nuevo usuario directamente desde la pantalla de login.

---

## Instalacion y ejecucion

### Opcion 1 — Ejecutable `.exe` (recomendado)

1. Descarga el archivo `Just Music.zip` desde la seccion [**Releases**](../../releases/latest)
2. Descomprime el ZIP
3. Abre la carpeta `Just Music` y ejecuta **`Just Music.exe`**
4. La musica ya esta incluida — no se requiere internet ni instalar Java

### Opcion 2 — Desde el codigo fuente

**Requisitos:**
- Oracle JDK 1.8.0 (debe ser Oracle, no Adoptium — incluye JavaFX)
- NetBeans IDE

```bash
git clone https://github.com/Juan-Exe/Proyecto-Just-Music.git
```

Abre el proyecto en NetBeans y ejecuta `ProyectoJustMusic.java`.

> **Nota:** El proyecto requiere Oracle JDK 8 especificamente porque JavaFX esta incluido en ese JDK. Versiones de Adoptium/OpenJDK no incluyen JavaFX.

---

## Albums incluidos

| Artista | Album | Ano | Genero |
|---------|-------|-----|--------|
| Tool | Lateralus | 2001 | Progressive Metal |
| Deftones | White Pony | 2000 | Alternative Metal |
| Deftones | Koi No Yokan | 2012 | Alternative Metal |
| Kendrick Lamar | DAMN. | 2017 | Hip-Hop / Rap |
| Kendrick Lamar | Mr. Morale & The Big Steppers | 2022 | Hip-Hop / Rap |
| Red Hot Chili Peppers | Californication | 1999 | Alternative Rock |
| Red Hot Chili Peppers | The Getaway | 2016 | Alternative Rock |
| Twenty One Pilots | Blurryface | 2015 | Indie Pop / Rock |
| Twenty One Pilots | Trench | 2018 | Indie Pop / Rock |
| Michael Jackson | Thriller | 1982 | Pop |
| A$AP Rocky | Testing | 2018 | Hip-Hop / Rap |
| Future & Metro Boomin | We Don't Trust You | 2024 | Hip-Hop / Trap |
| S_C_O_O_T_0_5 | Lisa - Cover | 2024 | Indie Rock |

---

## Aviso Legal y Derechos de Autor

> **Este proyecto es estrictamente academico y de portafolio. No tiene fines comerciales ni lucrativos. No se distribuye, vende ni reproduce ningun contenido musical con intencion de infringir derechos de autor.**

Las canciones y albums incluidos son propiedad de sus respectivos artistas, compositores y sellos discograficos:

**Tool**
- **Lateralus** (2001) — © Tool Dissectional / Volcano Entertainment. Compositores: Maynard James Keenan, Adam Jones, Danny Carey, Justin Chancellor.

**Deftones**
- **White Pony** (2000) — © Maverick Records. Compositores: Chino Moreno, Stephen Carpenter, Chi Cheng, Abe Cunningham, Frank Delgado.
- **Koi No Yokan** (2012) — © Reprise Records. Compositores: Chino Moreno, Stephen Carpenter, Abe Cunningham, Frank Delgado, Sergio Vega.

**Kendrick Lamar**
- **DAMN.** (2017) — © Top Dawg Entertainment / Aftermath / Interscope Records. Compositor principal: Kendrick Lamar Duckworth.
- **Mr. Morale & The Big Steppers** (2022) — © Top Dawg Entertainment / pgLang / Interscope Records. Compositor principal: Kendrick Lamar Duckworth.

**Red Hot Chili Peppers**
- **Californication** (1999) — © Warner Records. Compositores: Anthony Kiedis, Flea, John Frusciante, Chad Smith.
- **The Getaway** (2016) — © Warner Records. Compositores: Anthony Kiedis, Flea, Josh Klinghoffer, Chad Smith.

**Twenty One Pilots**
- **Blurryface** (2015) — © Fueled by Ramen. Compositores: Tyler Joseph, Josh Dun.
- **Trench** (2018) — © Fueled by Ramen. Compositores: Tyler Joseph, Josh Dun.

**Michael Jackson**
- **Thriller** (1982) — © Epic Records / MJJ Productions. Productor: Quincy Jones. Compositores: Michael Jackson, Rod Temperton, entre otros.

**A$AP Rocky**
- **Testing** (2018) — © ASAP Worldwide / Under the Influence of Music / RCA Records. Compositor principal: Rakim Athelaston Mayers.

**Future & Metro Boomin**
- **We Don't Trust You** (2024) — © Epic Records / Freebandz / Republic Records. Compositores: Nayvadius DeMun Wilburn, Leland Tyler Wayne.

**S_C_O_O_T_0_5**
- **Lisa - Cover** (2024) — Obra original del artista independiente S_C_O_O_T_0_5. Todos los derechos reservados al autor.

---

## Fair Use

El uso del contenido musical en este proyecto se enmarca dentro del contexto educativo y demostrativo, sin monetizacion, distribucion publica del audio ni reproduccion masiva. El codigo fuente es el objeto de demostracion; las canciones son unicamente un recurso funcional para simular la experiencia de una plataforma de streaming real.

Si eres titular de derechos y tienes alguna objecion, puedes contactarme directamente para retirar el contenido de inmediato.

---

## Autor

Desarrollado por **Juan Diego Arrieta Herrera**.

---

<div align="center">

*Just Music 2024 — Proyecto academico. Todos los derechos de las obras musicales pertenecen a sus respectivos autores y sellos discograficos.*

</div>
