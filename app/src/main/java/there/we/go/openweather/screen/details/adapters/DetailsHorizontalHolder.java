package there.we.go.openweather.screen.details.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import there.we.go.openweather.R;
import there.we.go.openweather.model.ExtWeather;

/**
 * @author Vladislav Falzan.
 */

public class DetailsHorizontalHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvDay)
    TextView tvDay;

    public DetailsHorizontalHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public static DetailsHorizontalHolder create(Context context) {
        return new DetailsHorizontalHolder(View.inflate(context, R.layout.details_horizontal_item, null));
    }

    public void bind(ExtWeather extWeather) {
        tvDay.setText(String.valueOf(extWeather.getMain().getPressure()));
    }
}