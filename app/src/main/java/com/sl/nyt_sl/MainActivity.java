package com.sl.nyt_sl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements newsAdapter.OnItemClickListener
{
 private RecyclerView mRecyclerview;
 private newsAdapter mNewsAdapter;
 private ArrayList<newsitem> mNewsList;
 private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerview=findViewById(R.id.recycler_view);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        mNewsList=new ArrayList<>();

        mRequestQueue= Volley.newRequestQueue(this);
       ParseJSON("https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Made by Suraj Lad For Test For Heady.io," +
                        "\n Surajlad27@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void ParseJSON(String url)
    {
          // No Need of This Now
        // String url="https://api.nytimes.com/svc/topstories/v2/business.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    JSONArray mjSonArray = response.getJSONArray("results");
                    for(int i=0;i<mjSonArray.length();i++)
                    {
                        JSONObject results=mjSonArray.getJSONObject(i);

                        String NewsTitle=results.getString("title");
                        String NewAb=results.getString("abstract");
                        String NewDT=results.getString("published_date");
                        String NewLink=results.getString("url");

                        mNewsList.add(new newsitem(NewsTitle,NewAb,NewDT,NewLink));
                    }
                    mNewsAdapter = new newsAdapter(MainActivity.this,mNewsList);
                    mRecyclerview.setAdapter(mNewsAdapter);
                    mNewsAdapter.setOnItemClickListener(MainActivity.this);
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_arts)
        {
            mNewsList.clear();
            mNewsAdapter.notifyDataSetChanged();

            mRecyclerview.removeAllViewsInLayout();
            String url="https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";
            ParseJSON(url);
            return true;
        }
        if (id == R.id.action_automobiles)
        {
            mNewsList.clear();
            mNewsAdapter.notifyDataSetChanged();

            mRecyclerview.removeAllViewsInLayout();
            String url="https://api.nytimes.com/svc/topstories/v2/automobiles.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";
            ParseJSON(url);
            return true;
        }
        if (id == R.id.action_business)
        {
            mNewsList.clear();
            mNewsAdapter.notifyDataSetChanged();

            mRecyclerview.removeAllViewsInLayout();
            String url="https://api.nytimes.com/svc/topstories/v2/business.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";
            ParseJSON(url);
            return true;
        }
        if (id == R.id.action_fashion)
        {
            mNewsList.clear();
            mNewsAdapter.notifyDataSetChanged();

            mRecyclerview.removeAllViewsInLayout();
            String url="https://api.nytimes.com/svc/topstories/v2/fashion.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";
            ParseJSON(url);
            return true;
        }
        if (id == R.id.action_food)
        {
            mNewsList.clear();
            mNewsAdapter.notifyDataSetChanged();

            mRecyclerview.removeAllViewsInLayout();
            String url="https://api.nytimes.com/svc/topstories/v2/food.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";
            ParseJSON(url);
            return true;
        }
        if (id == R.id.action_insider)
        {
            mNewsList.clear();
            mNewsAdapter.notifyDataSetChanged();

            mRecyclerview.removeAllViewsInLayout();
            String url="https://api.nytimes.com/svc/topstories/v2/insider.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";
            ParseJSON(url);
            return true;
        }
        if (id == R.id.action_magzines)
        {
            mNewsList.clear();
            mNewsAdapter.notifyDataSetChanged();

            mRecyclerview.removeAllViewsInLayout();
            String url="https://api.nytimes.com/svc/topstories/v2/magazine.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";
            ParseJSON(url);
            return true;
        }
        if (id == R.id.action_movies)
        {
            mNewsList.clear();
            mNewsAdapter.notifyDataSetChanged();

            mRecyclerview.removeAllViewsInLayout();
            String url="https://api.nytimes.com/svc/topstories/v2/movies.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";
            ParseJSON(url);
            return true;
        }
        if (id == R.id.action_sports)
        {
            mNewsList.clear();
            mNewsAdapter.notifyDataSetChanged();

            mRecyclerview.removeAllViewsInLayout();
            String url="https://api.nytimes.com/svc/topstories/v2/sports.json?api-key=demyXza1uoBqEoM0vEiQhfgYlszMeixK";
            ParseJSON(url);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int pos)
    {
        newsitem clickeditem=mNewsList.get(pos);

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(clickeditem.getNewsLink()));
        startActivity(browserIntent);
    }
}
