package createStory;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import com.example.myapplication.R;

public class GalleryAdapter extends BaseAdapter {

    private Context ctx;
    private int pos;
    private ImageView imageView;
    private LayoutInflater inflater;
    ArrayList<Uri> uris;

    public GalleryAdapter(Context ctx, ArrayList<Uri> uris) {
        this.ctx = ctx;
        this.uris = uris;
    }

    @Override
    public int getCount() {
        return uris.size();
    }

    @Override
    public Object getItem(int position) {
        return uris.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        pos=position;
        inflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=inflater.inflate(R.layout.gv_image,parent,false);
        imageView=itemView.findViewById(R.id.imageGallery);
        imageView.setImageURI(uris.get(position));
        return itemView;
    }
}
