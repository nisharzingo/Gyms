package details.hotel.app.fitiam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import details.hotel.app.fitiam.Model.NavBarItems;
import details.hotel.app.fitiam.R;

public class MoreAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavBarItems> mList = new ArrayList<>();

    public MoreAdapter(Context context, ArrayList<NavBarItems> mList)
    {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int pos) {
        return mList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.more_adapter,viewGroup,false);
        }

        TextView mTitle = (TextView) view.findViewById(R.id.title);


        mTitle.setText(mList.get(pos).getTitle().toString());

        return view;
    }
}
