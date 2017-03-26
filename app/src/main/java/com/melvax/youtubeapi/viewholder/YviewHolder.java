package com.melvax.youtubeapi.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//import android.support.v7.appcompat.R;
import com.melvax.youtubeapi.model.Item;
import com.melvax.youtubeapi.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by user on 17/03/2017.
 */

public class YviewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView description;
    private ImageView img;
    private TextView date;
    private Context c;



    public YviewHolder(View item_video){
        super(item_video);
        title=(TextView) item_video.findViewById(android.support.v7.appcompat.R.id.title);
        description=(TextView) item_video.findViewById(com.melvax.youtubeapi.R.id.description);
        img=(ImageView) item_video.findViewById(R.id.imageView);
        date=(TextView) item_video.findViewById(R.id.date);

    }

    public void bind(Item item) {
        title.setText(item.getSnippet().getTitle());
        date.setText(item.getSnippet().getPublishedAt());
        description.setText(item.getSnippet().getDescription());


        //Drawable d= LoadImageFromWebOperations("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
        //img.setImageDrawable(R.drawable.yimg);    }

    }

}
