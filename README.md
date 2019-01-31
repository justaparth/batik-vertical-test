# batik-vertical-test


## Overview
Testing some vertical rendering issues with apache batik.

## Main Code
The java version is located under `src/main/VerticalTest.java` while the browser version is locade under `web/svg_page.html`. The svgs are exactly the same (except for small changes like `href` vs `xlink:href` and the relative path to the font file.)

## How To Run

### Java

```
./gradlew run
```

### In Browser
Navigate to the `web` directory and open `svg_page.html` in Chrome.

## The Difference
In the browser, punctuation is properly rotated, but in batik it is not.

#### Browser:
![browser_version](readme_resources/chrome_result.png)

#### Batik:
![batik_version](readme_resources/batik_result.png)
