package packagename;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    AdView mAdView;

    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    DatabaseReference h1,c1,c2,c3,dt,dw,ba,bb,bc,td;
    TextView hd1,content1,content2,content3,date,draw,bda,bdb,bdc,three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdRequest adRequest = new AdRequest.Builder().build();

                // Prepare the Interstitial Ad
                interstitial = new InterstitialAd(MainActivity.this);
        // Insert the Ad Unit ID
                interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

                interstitial.loadAd(adRequest);
        // Prepare an Interstitial Ad Listener
                interstitial.setAdListener(new AdListener() {
                    public void onAdLoaded() {
        // Call displayInterstitial() function
                        displayInterstitial();
                    }
                });

        mAdView = (AdView) findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        hd1 = (TextView)findViewById(R.id.head1);
        content1 = (TextView)findViewById(R.id.content1);
        content2 = (TextView)findViewById(R.id.content2);
        content3 = (TextView)findViewById(R.id.content3);

        date = (TextView)findViewById(R.id.date);
        draw = (TextView)findViewById(R.id.draw);

        bda = (TextView)findViewById(R.id.a);
        bdb = (TextView)findViewById(R.id.b);
        bdc = (TextView)findViewById(R.id.c);

        three = (TextView)findViewById(R.id.three_digit);

        h1 = FirebaseDatabase.getInstance().getReference().child("result").child("heading");

        c1 = FirebaseDatabase.getInstance().getReference().child("result").child("content1");
        c2 = FirebaseDatabase.getInstance().getReference().child("result").child("content2");
        c3 = FirebaseDatabase.getInstance().getReference().child("result").child("content3");

        dt = FirebaseDatabase.getInstance().getReference().child("result").child("date");
        dw = FirebaseDatabase.getInstance().getReference().child("result").child("draw");


        ba = FirebaseDatabase.getInstance().getReference().child("result").child("a");
        bb = FirebaseDatabase.getInstance().getReference().child("result").child("b");
        bc = FirebaseDatabase.getInstance().getReference().child("result").child("c");

        td = FirebaseDatabase.getInstance().getReference().child("result").child("three_digit");


        h1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                hd1.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        c1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                content1.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        c2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                content2.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        c3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                content3.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        dt.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                date.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        dw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                draw.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        ba.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                bda.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        bb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                bdb.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        bc.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                bdc.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        td.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str;
                str=dataSnapshot.getValue(String.class);
                three.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
