package com.bitspilani.library.infoBits;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class ebooks extends AppCompatActivity {

    public Toolbar toolbar;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ebooks1);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        File profilepic = new File(dir, avatar);
//        try {
//            fileInput = new FileInputStream(profilepic);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        if(fileInput != null){
//            setToolBarAvatar(profilepic);
//        }
        ListView l = (ListView) findViewById(R.id.ebookList);
        String[] ebooks = {"Pearson Education", "Open Textbook Library", "Springer", "Taylor & Francis eBooks", "Open Access", "Intech", "Science Direct", "Mc Graw Hill India", "Cambridge University Press", "Wiley Blackwell", "IOP Science", "Open Texts", "Perpetual Access", "EBSCO"};
        Integer[] ebookImages = {R.mipmap.pearson_education1, R.mipmap.opentextbook_library1, R.mipmap.springer, R.mipmap.taylor1, R.mipmap.oapen, R.mipmap.intech1, R.mipmap.science_direct1, R.mipmap.mcgrawhill, R.mipmap.cambridge, R.mipmap.wiley, R.mipmap.iopscience, R.mipmap.open_texts, R.mipmap.perpetual_access, R.mipmap.ebsco1};
        TextView click = (TextView) findViewById(R.id.ebscoClick);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ebooks.this, CustomWebView.class).putExtra("url", "https://ecm.ebscohost.com/User/Login").putExtra("title", "EBSCO");

//                new Intent(Intent.ACTION_VIEW, Uri.parse("https://ecm.ebscohost.com/User/Login"));
                startActivity(i);
            }
        });
        Intent[] links = {
                new Intent(ebooks.this, downloadable_links.class).putExtra("reference", "Pearson e-Books"),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("http://open.umn.edu/opentextbooks/")),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("http://link.springer.com/search/page/3?showAll=false&facet-content-type=%22Book%22")),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tandfebooks.com/page/openaccess#listofOAtitles")),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.oapen.org/search?sort=year;f1-language=English")),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.intechopen.com/books")),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "http://open.umn.edu/opentextbooks/").putExtra("title", "Open TextBook Library"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "http://link.springer.com/search/page/3?showAll=false&facet-content-type=%22Book%22").putExtra("title", "Springer"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "http://www.tandfebooks.com/page/openaccess#listofOAtitles").putExtra("title", "Taylor and Francis"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "http://www.oapen.org/search?sort=year;f1-language=English").putExtra("title", "Open Access"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "http://www.intechopen.com/books").putExtra("title", "Intech"),
                new Intent(ebooks.this, downloadable_links.class).putExtra("reference", "Elsevier e-Books"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "https://www.expresslibrary.mheducation.com/home").putExtra("title", "McGraw Hill"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "https://www.cambridge.org/core/what-we-publish/books").putExtra("title", "").putExtra("title", "Cambridge University Press"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "https://onlinelibrary.wiley.com/action/showPublications?PubType=book").putExtra("title", "Willey BlackWell"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "https://iopscience.iop.org/bookList/10/2").putExtra("title", "IOP Science"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "https://opentexts.world/").putExtra("title", "Open Texts"),
                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/services/E-books.php").putExtra("title", "Perpetual Access"),

                new Intent(ebooks.this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/pdf/EBSCO%20eBooks%20Mannual.pdf").putExtra("title", "EBSCO"),

//                new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.expresslibrary.mheducation.com/home")),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cambridge.org/core/what-we-publish/books")),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("https://onlinelibrary.wiley.com/action/showPublications?PubType=book")),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("https://iopscience.iop.org/bookList/10/2")),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("https://opentexts.world/")),
//                new Intent(Intent.ACTION_VIEW, Uri.parse("http://library.bits-pilani.ac.in/pdf/EBSCO%20eBooks%20Mannual.pdf"))
        };
        l.setAdapter(new MyAdapter(this, ebooks, ebookImages, links));
    }


    public class MyAdapter extends BaseAdapter {

        private String[] ebook;
        private Integer[] images;
        private Intent[] link;

        public MyAdapter(Context context, String[] ebooks, Integer[] ebook_images, Intent[] links) {
            ebook = ebooks;
            images = ebook_images;
            link = links;
        }

        @Override
        public int getCount() {
            return ebook.length;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View v = getLayoutInflater().inflate(R.layout.ebook_item, null);
            final TextView header = (TextView) v.findViewById(R.id.ebook);
            final ImageView image = (ImageView) v.findViewById(R.id.ebook_image);
            header.setText(ebook[position]);
            image.setImageResource(images[position]);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(link[position]);
                }
            });
            return v;
        }
    }

}

