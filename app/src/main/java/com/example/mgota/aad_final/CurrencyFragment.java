package com.example.mgota.aad_final;

import android.annotation.SuppressLint;
import android.app.VoiceInteractor;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CurrencyFragment extends Fragment{
    public final String urlBase = "https://api.fixer.io/";
    JsonObjectRequest request;
    RequestQueue queue;

    private TextView fragName, fragCode, fragResults;
    private TextView frag2015, frag2016, frag2017;
    private LinearLayout fragHistory;
    private EditText fragAmount;
    private Spinner fragSpinner;
    private Button fragButton;
    private CurrencyModel myCurrency;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String id = getArguments().getString(CurrencyActivity.myId);
        this.myCurrency = CurrencyCollection.getCollection().getElement(id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.currency_frag, container, false);

        fragName = view.findViewById(R.id.fragName);
        fragName.setText(this.myCurrency.getName());

        fragCode = view.findViewById(R.id.fragCode);
        fragCode.setText(this.myCurrency.getCode());

        fragButton = view.findViewById(R.id.fragButton);
        fragButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcResults();
            }
        });

        fragSpinner = view.findViewById(R.id.fragCountry);

        fragAmount = view.findViewById(R.id.fragAmount);
        fragHistory = view.findViewById(R.id.fragHistory);
        frag2015 = view.findViewById(R.id.frag2015);
        frag2016 = view.findViewById(R.id.frag2016);
        frag2017 = view.findViewById(R.id.frag2017);
        fragResults = view.findViewById(R.id.fragResults);

        return view;
    }

    private void calcResults() {
        String amount = fragAmount.getText().toString();
        String base = fragCode.getText().toString();
        String target = fragSpinner.getSelectedItem().toString();
        if(amount.isEmpty()){
            Toast.makeText(getContext(), "Please enter an amount to convert.", Toast.LENGTH_SHORT).show();
            //fragResults.setText("ERROR\nPLEASE ENTER AN AMOUNT TO CONVERT");
        }
        else if (base.equals(target)){
            fragHistory.setVisibility(View.GONE);
            fragResults.setText("Converting to " + target + "\n"
                    + "Conversion rate: 1.00" + "\n"
                    + "Converted amount: " + amount + "\n"
                    + "Why are you doing this again?");
        }
        else {
            Cache cache = new DiskBasedCache(getActivity().getCacheDir(), 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            queue = new RequestQueue(cache, network);
            queue.start();

            getHistory(base, target);
            getResults(amount, base, target);
        }
    }

    private void getHistory(String base, String target) {
        fragHistory.setVisibility(View.VISIBLE);
        final String myTarget = target;
        String url2015 = urlBase + "2015-01-01?base=" + base + "&symbols=" + target;
        request = new JsonObjectRequest(Request.Method.GET, url2015, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    double rate = response.getJSONObject("rates").getDouble(myTarget);
                    frag2015.setText("2015: " + String.valueOf(rate));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

        String url2016 = urlBase + "2016-01-01?base=" + base + "&symbols=" + target;
        request = new JsonObjectRequest(Request.Method.GET, url2016, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    double rate = response.getJSONObject("rates").getDouble(myTarget);
                    frag2016.setText("2016: " + String.valueOf(rate));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

        String url2017 = urlBase + "2017-01-01?base=" + base + "&symbols=" + target;
        request = new JsonObjectRequest(Request.Method.GET, url2017, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    double rate = response.getJSONObject("rates").getDouble(myTarget);
                    frag2017.setText("2017: " + String.valueOf(rate));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }

    private void getResults(String amount, String base, String target) {
        final String myAmount = amount;
        final String myTarget = target;
        String url = urlBase + "latest?base=" + base + "&symbols=" + target;
        System.out.println(url);
        request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //System.out.println(response);
                    JSONObject array = response.getJSONObject("rates");
                    String myDate = response.getString("date");
                    double rate = array.getDouble(myTarget);
                    double result = Double.parseDouble(myAmount) * rate;
                    @SuppressLint("DefaultLocale") String myResult = String.format("%.2f", result);
                    fragResults.setText("Converting to " + myTarget + "\n"
                            + "Rate retrieved on " + myDate + "\n"
                            + "Conversion rate: " + String.valueOf(rate) + "\n"
                            + "Converted amount: " + myResult);
                } catch (JSONException e) {
                    System.out.println("This failed");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                //System.out.println("This sucks");
            }
        });
        queue.add(request);
    }
}
