package there.we.go.openweather.screen.details.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import there.we.go.openweather.model.ExtWeather;

/**
 * @author Vladislav Falzan.
 */

public class DetailsHorizontalAdapter extends RecyclerView.Adapter<DetailsHorizontalHolder> {

    private final List<ExtWeather> mExtWeather;

    public DetailsHorizontalAdapter() {
        mExtWeather = new ArrayList<>();
    }

    public void changeDataSet(List<ExtWeather> extWeather) {
        mExtWeather.clear();
        mExtWeather.addAll(extWeather);
        notifyDataSetChanged();
    }

    public void clear() {
        mExtWeather.clear();
        notifyDataSetChanged();
    }

    @Override
    public DetailsHorizontalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return DetailsHorizontalHolder.create(parent.getContext());
    }

    @Override
    public void onBindViewHolder(DetailsHorizontalHolder holder, int position) {
        ExtWeather extWeather = mExtWeather.get(position);

        holder.bind(extWeather);
    }

    @Override
    public int getItemCount() {
        return mExtWeather.size();
    }
}
