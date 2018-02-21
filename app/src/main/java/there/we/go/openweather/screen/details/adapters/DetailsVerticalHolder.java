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

public class DetailsVerticalHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvDayOne)
    TextView tvDayOne;

    public DetailsVerticalHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public static DetailsVerticalHolder create(Context context) {
        return new DetailsVerticalHolder(View.inflate(context, R.layout.details_vertical_item, null));
    }

    public void bind(ExtWeather extWeather) {
        tvDayOne.setText(String.valueOf(extWeather.getMain().getHumidity()));
    }
}