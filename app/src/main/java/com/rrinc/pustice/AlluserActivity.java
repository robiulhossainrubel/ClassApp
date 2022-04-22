package com.rrinc.pustice;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.rrinc.pustice.support.StudentAdapter;
import com.rrinc.pustice.support.Students;

import java.util.ArrayList;
import java.util.List;

public class AlluserActivity extends AppCompatActivity {

    AdView mAdView;
    InterstitialAd mInterstitialAd;

    private RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    List<Students> studentsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alluser);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(this, getString(R.string.app_id));

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.ads_initial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                finish();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.listViewId);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        studentsList = new ArrayList<>();

        studentsList.add(new Students(
                "MITU RANI KUNDU",
                "Pabna",
                "01776166857",
                "B+",
                "Mitu",
                "1",
                "mitukundu0055@gmail.com",
                "3 October 2001",
                "Chatmoher Pilot High School",
                "Chatmoher Degree College", R.drawable.mitu));

        studentsList.add(new Students(
                "ZAMIUL ISLAM",
                "Ponchogar",
                "01757871711",
                "O+",
                "Himel",
                "2",
                "islam9himel@gmail.com",
                "11 February 1998",
                "Boda Govt. Pilot Model School and College",
                "Police Lines School and Collage,Rangpur", R.drawable.himel));

        studentsList.add(new Students(
                "ATIKUR RAHMAN",
                "Gazipur",
                "01633500198",
                "",
                "Atik",
                "3",
                "atikur.0908@gmail.com",
                "22 Decembar 2000",
                "BRRI High School", "MEH Arif College", R.drawable.atik));

        studentsList.add(new Students(
                "ABDUL MATIN",
                "Sirajgonj",
                "01797262843",
                "O+",
                "Matin",
                "4",
                "",
                "18 Novembar 2000",
                "Malotidanga Purbo Para High School",
                "Sirajgonj Govt. College", R.drawable.motin));

        studentsList.add(new Students(
                "OMAR FARUK",
                "Cumilla",
                "01831342230",
                "AB+",
                "Faruk",
                "5",
                "omorfaruk65142@gmail.com",
                "06 February 2000",
                "Morichakanda Zia smrity Adarsh High School",
                "Comilla City College", R.drawable.faruk));

        studentsList.add(new Students(
                "SAGOR MIA",
                "Bogura",
                "01747682342",
                "B+",
                "Sagor",
                "6",
                "musagor78@gmail.com",
                "17 February 1999",
                "Gabtali Pailot High School",
                "Gabtali Govt. College", R.drawable.mia));


        studentsList.add(new Students(
                "MASUD RANA",
                "Jamalpur",
                "01792010088",
                "O+",
                "Masud",
                "8",
                "masud.pust.ice08@gmail.com",
                "01 May 1999",
                "Gaibandha Suruzzahan High School",
                "Cantonment Public School and College", R.drawable.masud));

        studentsList.add(new Students(
                "RAHATUL RABBI",
                "Lalmonirhat",
                "01790224950",
                "AB+",
                "Ratul",
                "9",
                "rahatul.ice.09.pust@gmail.com",
                "03 March 1999",
                "Babanipur Sefatiya Kamil Madrasah",
                "Babanipur Sefatiya Kamil Madrasah", R.drawable.ratul));

        studentsList.add(new Students(
                "SHA ALAM",
                "Natore",
                "01777417448",
                "A+",
                "Shourov",
                "10",
                "shourov628@gmail.com",
                "10 June 2000",
                "Borobaria High School",
                "Ajom Ali College", R.drawable.sowrob));

        studentsList.add(new Students(
                "MEHEDI HASAN",
                "Rajshahi",
                "01773634851",
                "AB+",
                "Mehedi",
                "11",
                "mehedihasan0177363@gmail.com",
                "14 Novembar 1999",
                "Nazirgonj High School and College",
                "Shahid A.H.M.Khamarudzzaman Govt. Degree college", R.drawable.mehedi));


        studentsList.add(new Students(
                "MAHFUZUR RAHMAN",
                "Mymanshingh",
                "01753903622",
                "AB+",
                "Akash",
                "13",
                "akashmahfuzur@gmail.com",
                "01 Novembar 2000",
                "Nabarun Biddya Niketon",
                "Shahid Smrity Govt. college", R.drawable.akash));

        studentsList.add(new Students(
                "ROBIUL HOSSAIN RUBEL",
                "Cumilla",
                "01714775107",
                "O+",
                "Rubel",
                "14",
                "Hossainrobiul33@gmail.com",
                "30 July 1999",
                "Laksam Pilot High School",
                "B.A.F Shaheen college Kurmitola", R.drawable.rubel));

        studentsList.add(new Students(
                "IMRAN HOSSAIN",
                "Pabna",
                "",
                "",
                "Imran",
                "15",
                "",
                "",
                "",
                "", R.drawable.emran));

        studentsList.add(new Students(
                "NAIM HOSSAIN",
                "Chapai Nawabgoan",
                "01774289775",
                "O+",
                "Naim",
                "16",
                "naimhossain1006@gmail.com",
                "04 Octobar 1998",
                "Binodpur High School",
                "Nawabgonj City College", R.drawable.nyme));

        studentsList.add(new Students(
                "SHAHANUR RAHMAN",
                "Sylhet",
                "01786790941",
                "",
                "Sohan",
                "17",
                "shahanur941@gmail.com",
                "27 April 1999",
                "Asirgonj High school and College",
                "Dhakadakshin Multilateral High School and College", R.drawable.sohan));

        studentsList.add(new Students(
                "MIZANUR RAHMAN",
                "Bogura",
                "01756736056",
                "B+",
                "Mizan",
                "18",
                "mizan596644@gmail.com",
                "18 Augast 1998",
                "Dhankundi Shahnaj Siraj High School",
                "Govt. Shah Sultan  Collage", R.drawable.mizan));

        studentsList.add(new Students(
                "SAGOR SARDER",
                "Barisal",
                "01884851747",
                "A+",
                "Sagor",
                "19",
                "sa5252144@gmail.com",
                "04 March 1999",
                "Goumadi Pilot Secondary School",
                "Mahilara Degree College", R.drawable.sagor));

        studentsList.add(new Students(
                "SUMAIYA KHATUN",
                "Jhenaidah",
                "01704942794",
                "AB+",
                "Sumaiya",
                "20",
                "sumaiyapust20@gmail.com",
                "18 February 2000",
                "Garagonj Grils High School",
                "Mia Jinna Alam Degree College", R.drawable.sumiya));

        studentsList.add(new Students(
                "SHAHADAT HOSSAIN BHUIAN",
                "Cumilla",
                "01516707518",
                "O+",
                "Shadat",
                "21",
                "md.shahadathossain1@outlook.com",
                "20 June 2000",
                "Muradnagar D.R. Govt. High School",
                "Kazi Noman Ahmed Degree College", R.drawable.shadat));

        studentsList.add(new Students(
                "IMRAN HOSSAIN",
                "Jessore", "01989889418",
                "B+",
                "Imran",
                "22",
                "imran889418@gmail.com",
                "06 April 1999",
                "Chowgacha Hazi sarder Mortoz high School",
                "M.M. College", R.drawable.emu));

        studentsList.add(new Students(
                "SAGOR MOLLAH",
                "Jhenaidah",
                "01760858237",
                "A+",
                "Sagor",
                "23",
                "sfahimislam611@gmail.com",
                "07 May 1998",
                "Benipur high School",
                "Shailkupa Govt. Degree college", R.drawable.molla));

        studentsList.add(new Students(
                "Z.H.M.KHAIRUL BASAR",
                "Rajshahi",
                "01760858237",
                "O+",
                "Khairul",
                "24",
                "khairulbasar9999@gmail.com",
                "25 Decembar 2000",
                "Shiroil Govt. High School",
                "New Govt. Degree College", R.drawable.khairul));

        studentsList.add(new Students(
                "SAKIB HASAN",
                "Joypurhat",
                "01732878450",
                "A+",
                "Sakib",
                "25",
                "hasansakib047@gmail.com",
                "20 Decembar 2000",
                "R.B. Govt. High School",
                "Joypurhat Govt.College", R.drawable.hasan));

        studentsList.add(new Students(
                "RAKIBU ZZAMAN",
                "Kustia",
                "01883387971",
                "O+",
                "Shadin",
                "26",
                "rshadhin7@gmail.com",
                "23 Octobar 1999",
                "Housing Estate High School",
                "Kushtia Govt. College", R.drawable.shadin));

        studentsList.add(new Students(
                "ABDUL HALIM",
                "Pabna",
                "01722411795",
                "A+",
                "Halim",
                "27",
                "abcdhalimabcd@gmail.com",
                "15 February 1997",
                "Komorpur High School",
                "Shahid Bulbul Govt. College", R.drawable.halim));

        studentsList.add(new Students(
                "RIFAT SARKAR",
                "Dhaka",
                "01959045708",
                "A+",
                "Rifat",
                "28",
                "rifatsarker7252@gmail.com",
                "14 Decembar 1999",
                "Chandidwar High School",
                "Shaheed Ramiz Uddin Cantonment College", R.drawable.rifat));

        studentsList.add(new Students(
                "MONJURUL ALAM",
                "Sirajgonj",
                "01783073662",
                "AB+",
                "Monjur",
                "29",
                "shouravmonjurul@gmail.com",
                "16 Auguest 2000",
                "Moon Light Kindergaten and High School",
                "Sirajgoanj Govt. Collage", R.drawable.monju));

        studentsList.add(new Students(
                "SAYMA SADIA",
                "Rajbari",
                "01763443905",
                "B+",
                "Sadia",
                "30",
                "saymasadia1122@gmail.com",
                "13 July 2000",
                "Yeakub Ali Chowdury Bidyapith",
                "Pangsha Government College", R.drawable.sadia));

        studentsList.add(new Students(
                "SOHAG HOSSAIN",
                "Kurigraam",
                "01761236455",
                "O+",
                "Sohag",
                "31",
                "sohaghossainice@gmail.com",
                "06 March 1998",
                "Joymonirhat MUBL High School",
                "Bhurungamari Govt. College", R.drawable.sohag));

        studentsList.add(new Students(
                "JANNATUL NAYEM",
                "Mymensingh",
                "01303194760",
                "",
                "Nayem",
                "32",
                "nayeem1427@gmail.com",
                "01 Septembar 1999",
                "Dukhu Mia Biddaniketon",
                "Agricultural Univercity College", R.drawable.ny));

        studentsList.add(new Students(
                "SHAHINUR",
                "Sirajgonj",
                "01787825118",
                "B+",
                "Shahin",
                "33",
                "sumonshahin225@gmail.com",
                "15 March 1999",
                "Shambudia M.L. High School",
                "Manju Kader college", R.drawable.shahin));

        studentsList.add(new Students(
                "MEHEDI HASAN",
                "Kustia",
                "01761060923",
                "O+",
                "Bappy",
                "34",
                "mehedihasan10@gmail.com",
                "23 July 1998",
                "Bahadurpur High School",
                "Chuadanga Govt. College", R.drawable.bappy));

        studentsList.add(new Students(
                "JOY SAHA",
                "Tangail",
                "01756652161",
                "B+",
                "Joy",
                "35",
                "joysahaice0919@gmail.com",
                "05 Septembar 2000",
                "Porabari High School",
                "Islami University and Technical College", R.drawable.joy));

        studentsList.add(new Students(
                "SHARIF AHAMMED",
                "Sherpur",
                "",
                "",
                "Sharif",
                "36",
                "",
                "",
                "",
                "", R.drawable.sorif));

        studentsList.add(new Students(
                "FARIHA MAHZABIN",
                "Sherpur",
                "01729821056",
                "A+",
                "Mahi",
                "37",
                "farihamahzabin523@gmail.com",
                "13 Novembar 2001",
                "Abdul Hakim Smrity Girls High School",
                "Sherpur Govt. College", R.drawable.mahi));

        studentsList.add(new Students(
                "SHOAIB AHMAD",
                "Jessore",
                "01763430682",
                "A+",
                "Sakib",
                "38",
                "",
                "28 February 2000",
                "Jessore Zilla School",
                "Daud Public College", R.drawable.sakib));

        studentsList.add(new Students(
                "MAHFUZUR RAHMAN",
                "Jhenaidah",
                "01782139417",
                "B+",
                "Mahfuz",
                "39",
                "rakib132108@gmail.com",
                "4 January 2001",
                "Hat Barobazar High School",
                "Kazi Nazrul Islam College", R.drawable.mahfuz));

        studentsList.add(new Students(
                "SHAHINUL ISLAM",
                "Rajbari",
                "017878025120",
                "A+",
                "Shahin",
                "40",
                "islamssahhinul@gmail.com",
                "30 Decembar 1999",
                "Dhokrakol High School",
                "Rajbari Govt. College", R.drawable.islam));


        studentAdapter = new StudentAdapter(getApplicationContext(),studentsList);
        recyclerView.setAdapter(studentAdapter);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem menuItem =menu.findItem(R.id.searchMenu);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Students> filtermodelList=filter(studentsList,newText);
                studentAdapter.update(filtermodelList);
                return true;
            }
        });

        return true;
    }

    private List<Students> filter(List<Students> pl,String qury) {

        qury=qury.toLowerCase();
        final List<Students> filterModelList =new ArrayList<>();
        for (Students model :pl)
        {
            final String text =model.getName().toLowerCase();
            if (text.startsWith(qury))
            {
                filterModelList.add(model);
            }
        }
        return filterModelList;
    }
}
