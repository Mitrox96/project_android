package fr.ugatir.cda1_android

import android.app.Application

class AppEpsi:Application() {
    override fun onCreate() {
        super.onCreate()
    }

    val data="{\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"picture_url\": \"https://www.numerama.com/content/uploads/2019/05/trou-noir-espace-univers-astronomie.jpg\",\n" +
            "      \"name\": \"Allan\",\n" +
            "      \"email\": \"allan@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg\",\n" +
            "      \"name\": \"Arraud\",\n" +
            "      \"email\": \"arraud@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://media.gettyimages.com/photos/colorful-powder-explosion-in-all-directions-in-a-nice-composition-picture-id890147976?s=2048x2048\",\n" +
            "      \"name\": \"Nicolas\",\n" +
            "      \"email\": \"nicolas@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Lilian\",\n" +
            "      \"email\": \"lilian@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/2/3/1/2310c9171a_50157784_pia23441.jpg\",\n" +
            "      \"name\": \"Maxime\",\n" +
            "      \"email\": \"maxime@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg\",\n" +
            "      \"name\": \"Arraud\",\n" +
            "      \"email\": \"arraud@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://media.gettyimages.com/photos/colorful-powder-explosion-in-all-directions-in-a-nice-composition-picture-id890147976?s=2048x2048\",\n" +
            "      \"name\": \"Nicolas\",\n" +
            "      \"email\": \"nicolas@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Lilian\",\n" +
            "      \"email\": \"lilian@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/2/3/1/2310c9171a_50157784_pia23441.jpg\",\n" +
            "      \"name\": \"Maxime\",\n" +
            "      \"email\": \"maxime@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg\",\n" +
            "      \"name\": \"Arraud\",\n" +
            "      \"email\": \"arraud@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://media.gettyimages.com/photos/colorful-powder-explosion-in-all-directions-in-a-nice-composition-picture-id890147976?s=2048x2048\",\n" +
            "      \"name\": \"Nicolas\",\n" +
            "      \"email\": \"nicolas@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Lilian\",\n" +
            "      \"email\": \"lilian@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/2/3/1/2310c9171a_50157784_pia23441.jpg\",\n" +
            "      \"name\": \"Maxime\",\n" +
            "      \"email\": \"maxime@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg\",\n" +
            "      \"name\": \"Arraud\",\n" +
            "      \"email\": \"arraud@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://media.gettyimages.com/photos/colorful-powder-explosion-in-all-directions-in-a-nice-composition-picture-id890147976?s=2048x2048\",\n" +
            "      \"name\": \"Nicolas\",\n" +
            "      \"email\": \"nicolas@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Lilian\",\n" +
            "      \"email\": \"lilian@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"picture_url\": \"https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/2/3/1/2310c9171a_50157784_pia23441.jpg\",\n" +
            "      \"name\": \"Maxime\",\n" +
            "      \"email\": \"maxime@epsi.fr\",\n" +
            "      \"city\": \"Bordeaux\",\n" +
            "      \"phone\": \"0619191919\",\n" +
            "      \"zipcode\": \"33000\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"
}