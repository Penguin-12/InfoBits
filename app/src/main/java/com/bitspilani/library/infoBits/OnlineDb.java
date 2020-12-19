package com.bitspilani.library.infoBits;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.bitspilani.library.infoBits.homepage.avatar;
import static com.bitspilani.library.infoBits.homepage.fileInput;

public class OnlineDb extends AppCompatActivity {
    Toolbar toolbar;
    File dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_db);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dir = getFilesDir();
        final String[] OnlineDb = {"ACM (Association for Computing Machinery)", "AIP (American Institute of Physics)", "ACS (American Chemical Society)", "APS (American Physical Society)", "ASCE (American Society of Civil Engineers)", "ASME (American Society of Mechanical Engineers)", "Annual Reviews", "Bentham Science", "Capitaline Plus", "Cambridge University Press", "EBSCO", "Emerald Group Publishing", "Grammarly", "Scopus", "HeySuccess", "IEEE (Institute of Electrical and Electronics Engineers)", "IndiaStat", "IOP (Institute of Physics)", "Institute of Mechanical Engineers(IMechE)", "JSTOR", "MathSciNet", "MethodsNow", "OUP (Oxford University Press)", "Portland Press", "Project Euclid", "Project Muse", "Proquest Online", "RSC (Royal Society of Chemistry)", "Springer", "Science Direct", "SciFinder", "SIAM (Society for Industrial and Apllied Mathematics)", "Taylor & Francis", "Wiley Interscience", "Learn More", "Open Access Resources"};
        final String[] DbLinks = {"https://dl.acm.org/", "http://www.aip.org", "http://pubs.acs.org/about.html", "http://www.aps.org/", "https://ascelibrary.org/journals", "http://asmedigitalcollection.asme.org/journals.aspx", "http://arjournals.annualreviews.org/", "http://www.eurekaselect.com", "http://www.capitaline.com/user/framepage.asp?id=1", "http://www.journals.cambridge.org/", "https://publications.ebsco.com/?custId=ns189876&groupId=main&profileId=pfui", "http://www.emeraldinsight.com/", "https://www.grammarly.com/edu", "https://www.scopus.com/home.uri", "https://www.heysuccess.com", "http://www.ieee.org/ieeexplore/", "https://www.indiastat.com", "http://www.iop.org/EJ/", "http://library.bits-pilani.ac.in/pdf/ime.pdf", "http://www.jstor.org/", "http://www.ams.org/mathscinet/index.html", "https://sso.cas.org/as/Jd2pN/resume/as/authorization.ping", "http://www.oxfordjournals.org/en/", "http://www.portlandpress.com/", "http://projecteuclid.org/", "http://muse.jhu.edu/", "http://search.proquest.com/?accountid=81487", "http://www.rsc.org/is/journals/current/ejs.htm", "http://www.springerlink.com/journals/", "http://www.sciencedirect.com/", "http://library.bits-pilani.ac.in/services/SciFinder_registration.php", "http://epubs.siam.org", "http://www.tandfonline.com/", "http://www3.interscience.wiley.com/cgi-bin/home", "http://library.bits-pilani.ac.in/pdf/Databases/Complete_List_of_Onlne_Databases.pdf", "http://library.bits-pilani.ac.in/services/open_access_links.php"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, OnlineDb);
        ListView listView = (ListView) findViewById(R.id.onlineDb);
        listView.setAdapter(adapter);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent defaultIntent;
                defaultIntent = new Intent(OnlineDb.this, CustomWebView.class).putExtra("url", DbLinks[position]).putExtra("title", OnlineDb[position]);
//                defaultIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(DbLinks[position]));
               /* if(DbLinks[position].contains("pdf"))
                    defaultIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(DbLinks[position]));
                else
                */
                startActivity(defaultIntent);
            }
        });
        File profilepic = new File(dir, avatar);
        try {
            fileInput = new FileInputStream(profilepic);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(fileInput != null){
//            setToolBarAvatar(profilepic);
        }
    }
}
