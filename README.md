# Just Music 🎵

Una aplicación de escritorio de streaming de música desarrollada en **Java con JavaFX**, inspirada en plataformas como Tidal y Spotify. Proyecto académico de portafolio para demostrar habilidades en desarrollo de interfaces de usuario, arquitectura MVC y manejo de multimedia en Java.

---

## Descripción

Just Music permite explorar álbumes, reproducir canciones, gestionar artistas y navegar por una biblioteca musical con una interfaz moderna y fluida. Incluye dos tipos de usuarios: **Oyente** y **Artista**, cada uno con su propia experiencia dentro de la app.

### Funcionalidades principales

- Reproducción de música con controles de play/pausa, siguiente, anterior, aleatorio y bucle
- Barra de progreso interactiva sincronizada con la canción
- Lista de canciones scrollable con efecto hover por álbum
- Exploración de álbumes por artista
- Inicio de sesión y registro para oyentes y artistas
- Perfil de artista con contador de seguidores y reproducciones
- Interfaz adaptada según el tipo de usuario

---

## Usuarios de prueba

La aplicación usa autenticación sin base de datos externa. Usa las siguientes credenciales para probarla:

### Oyente
| Campo | Valor |
|-------|-------|
| Correo | `oyente@justmusic.com` |
| Contraseña | `oyente123` |

### Oyente alternativo
| Campo | Valor |
|-------|-------|
| Correo | `demo@justmusic.com` |
| Contraseña | `demo123` |

### Artista
| Campo | Valor |
|-------|-------|
| Correo | `artista@justmusic.com` |
| Contraseña | `artista123` |

### Artista alternativo (S_C_O_O_T_0_5)
| Campo | Valor |
|-------|-------|
| Correo | `scoot@justmusic.com` |
| Contraseña | `scoot123` |

> También puedes registrar un usuario nuevo directamente desde la pantalla de login.

---

## Cómo ejecutar

### Opción 1: Instalador `.exe` (recomendado)
1. Descarga el instalador desde la sección [Releases](../../releases)
2. Ejecuta el instalador y sigue los pasos
3. Abre **Just Music** desde el acceso directo
4. La música se incluye en la instalación — no se requiere internet

### Opción 2: Desde el código fuente
**Requisitos:**
- JDK 17 o superior
- JavaFX SDK 21
- NetBeans IDE (recomendado) o cualquier IDE con soporte JavaFX

```bash
git clone https://github.com/tu-usuario/Proyecto-Just-Music.git
```
Abre el proyecto en NetBeans y ejecuta `ProyectoJustMusic.java`.

---

## Álbumes incluidos

| Artista | Álbum | Año |
|---------|-------|-----|
| Tool | Lateralus | 2001 |
| Deftones | White Pony | 2000 |
| Deftones | Koi No Yokan | 2012 |
| Kendrick Lamar | DAMN. | 2017 |
| Kendrick Lamar | Mr. Morale & The Big Steppers | 2022 |
| Red Hot Chili Peppers | Californication | 1999 |
| Red Hot Chili Peppers | The Getaway | 2016 |
| Twenty One Pilots | Blurryface | 2015 |
| Twenty One Pilots | Trench | 2018 |
| Michael Jackson | Thriller | 1982 |
| A$AP Rocky | Testing | 2018 |
| Future & Metro Boomin | We Don't Trust You | 2024 |
| S_C_O_O_T_0_5 | Lisa - Cover | 2024 |

---

## Aviso Legal y Derechos de Autor

> **Este proyecto es estrictamente académico y de portafolio. No tiene fines comerciales ni lucrativos. No se distribuye, vende ni reproduce ningún contenido musical con intención de infringir derechos de autor.**

Las canciones y álbumes incluidos en esta aplicación son propiedad de sus respectivos artistas, compositores, sellos discográficos y titulares de derechos. A continuación se detalla la atribución de cada obra:

---

### Tool
- **Lateralus** (2001) — © Tool Dissectional / Volcano Entertainment. Compositores: Maynard James Keenan, Adam Jones, Danny Carey, Justin Chancellor.

### Deftones
- **White Pony** (2000) — © Maverick Records. Compositores: Chino Moreno, Stephen Carpenter, Chi Cheng, Abe Cunningham, Frank Delgado.
- **Koi No Yokan** (2012) — © Reprise Records. Compositores: Chino Moreno, Stephen Carpenter, Abe Cunningham, Frank Delgado, Sergio Vega.

### Kendrick Lamar
- **DAMN.** (2017) — © Top Dawg Entertainment / Aftermath / Interscope Records. Compositor principal: Kendrick Lamar Duckworth.
- **Mr. Morale & The Big Steppers** (2022) — © Top Dawg Entertainment / pgLang / Interscope Records. Compositor principal: Kendrick Lamar Duckworth.

### Red Hot Chili Peppers
- **Californication** (1999) — © Warner Records. Compositores: Anthony Kiedis, Flea, John Frusciante, Chad Smith.
- **The Getaway** (2016) — © Warner Records. Compositores: Anthony Kiedis, Flea, Josh Klinghoffer, Chad Smith.

### Twenty One Pilots
- **Blurryface** (2015) — © Fueled by Ramen. Compositores: Tyler Joseph, Josh Dun.
- **Trench** (2018) — © Fueled by Ramen. Compositores: Tyler Joseph, Josh Dun.

### Michael Jackson
- **Thriller** (1982) — © Epic Records / MJJ Productions. Productor: Quincy Jones. Compositores: Michael Jackson, Rod Temperton, entre otros.

### A$AP Rocky
- **Testing** (2018) — © ASAP Worldwide / Under the Influence of Music / RCA Records. Compositor principal: Rakim Athelaston Mayers.

### Future & Metro Boomin
- **We Don't Trust You** (2024) — © Epic Records / Freebandz / Republic Records. Compositores: Nayvadius DeMun Wilburn, Leland Tyler Wayne.

### S_C_O_O_T_0_5
- **Lisa - Cover** (2024) — Obra original del artista independiente S_C_O_O_T_0_5. Todos los derechos reservados al autor.

---

## Declaración de uso justo / Fair Use

El uso del contenido musical en este proyecto se enmarca dentro del contexto educativo y demostrativo, sin monetización, distribución pública del audio ni reproducción masiva. El código fuente de la aplicación es el objeto de demostración; las canciones son únicamente un recurso funcional para simular la experiencia de una plataforma de streaming real.

Si eres titular de derechos y tienes alguna objeción, puedes contactarme directamente para retirar el contenido de inmediato.

---

## Tecnologías utilizadas

- **Java 8 / JDK 17**
- **JavaFX 21** — interfaz gráfica
- **FXML** — diseño declarativo de vistas
- **CSS** — estilos personalizados
- **Patrón MVC** — arquitectura del proyecto
- **NetBeans IDE**

---

## Autor

Desarrollado por **Juan Diego** como proyecto de portafolio personal.

---

*Just Music © 2024 — Proyecto académico. Todos los derechos de las obras musicales pertenecen a sus respectivos autores y sellos discográficos.*
