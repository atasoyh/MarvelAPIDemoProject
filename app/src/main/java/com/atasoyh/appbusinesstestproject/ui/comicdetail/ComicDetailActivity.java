package com.atasoyh.appbusinesstestproject.ui.comicdetail;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.R;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.comicdetail.ComicDetailContract;
import com.atasoyh.appbusinesstestproject.presenter.comicdetail.ComicDetailPresenter;
import com.atasoyh.appbusinesstestproject.ui.base.BaseActivity;
import com.atasoyh.appbusinesstestproject.util.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Currency;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicDetailActivity extends BaseActivity implements ComicDetailContract.View {

    public static final String COMIC_ID = "ComicId";
    @Inject
    ComicDetailPresenter comicDetailPresenter;

    @Inject
    Configuration configuration;

    @BindView(R.id.sdv)
    SimpleDraweeView simpleDraweeView;

    @BindView(R.id.tvAuthor)
    TextView tvAuthor;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvPageCount)
    TextView tvPageCount;

    @BindView(R.id.tvPrice)
    TextView tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_comic_detail);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        comicDetailPresenter.loadComicDetail();
    }

    @Override
    protected void injectDependencies(DefaultApplication application) {
        String comicId = getIntent().getStringExtra(COMIC_ID);
        application.getComicDetailSubComponent((this), comicId).inject(this);
    }

    @Override
    protected void releaseSubComponents(DefaultApplication application) {
        application.removeComicDetailSubComponent();
    }

    @Override
    public void showComicDetail(Comic comic) {
        simpleDraweeView.setImageURI(comic.getThumbnail().getUrl());
        setAuthorText();
        setDescriptionText(comic);
        setPriceText(comic);
        setPageCount(comic);
    }

    private void setDescriptionText(Comic comic) {
        tvDescription.setText(String.format(getString(R.string.description), comic.getDescription()));
    }

    private void setPageCount(Comic comic) {
        tvPageCount.setText(String.format(getString(R.string.page_count), comic.getPageCount()));
    }

    private void setAuthorText() {
        tvAuthor.setText(String.format(getString(R.string.author), "-"));
    }

    private void setPriceText(Comic comic) {
        StringBuilder priceTextBuilder = new StringBuilder();
        Locale locale = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            locale = configuration.getLocales().get(0);
        } else locale = configuration.locale;

        for (int i = 0; i < comic.getPrices().size(); i++) {
            if (i != 0) priceTextBuilder.append('\n');
            priceTextBuilder.append(String.format(getString(R.string.price), Utils.getFormattedCurrency(comic.getPrices().get(i).getPrice(), locale, Currency.getInstance("USD")), comic.getPrices().get(i).getType()));
        }
        tvPrice.setText(priceTextBuilder.toString());
    }

    @Override
    public void showComicIdErrorAndFinishActivity() {
        finish();
    }
}
