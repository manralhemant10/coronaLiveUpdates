package com.example.coronaLiveUpdates;

import android.os.Parcel;
import android.os.Parcelable;

public class CountryWise implements Parcelable {
    String mCovidCountry, mCases, mTodayCases, mDeaths, mTodayDeaths, mRecovered, mActive, mCritical, mFlags;

    public CountryWise(String mCovidCountry, String mCases, String mTodayCases, String mDeaths, String mTodayDeaths, String mRecovered, String mActive, String mCritical) {
        this.mCovidCountry = mCovidCountry;
        this.mCases = mCases;
        this.mTodayCases = mTodayCases;
        this.mDeaths = mDeaths;
        this.mTodayDeaths = mTodayDeaths;
        this.mRecovered = mRecovered;
        this.mActive = mActive;
        this.mCritical = mCritical;
        this.mFlags = mFlags;
    }

    public String getmCovidCountry() {
        return mCovidCountry;
    }

    public String getmCases() {
        return mCases;
    }

    public String getmTodayCases() {
        return mTodayCases;
    }

    public String getmDeaths() {
        return mDeaths;
    }

    public String getmTodayDeaths() {
        return mTodayDeaths;
    }

    public String getmRecovered() {
        return mRecovered;
    }

    public String getmActive() {
        return mActive;
    }

    public String getmCritical() {
        return mCritical;
    }

    public String getmFlags() {
        return mFlags;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mCovidCountry);
        dest.writeString(this.mCases);
        dest.writeString(this.mTodayCases);
        dest.writeString(this.mDeaths);
        dest.writeString(this.mTodayDeaths);
        dest.writeString(this.mRecovered);
        dest.writeString(this.mActive);
        dest.writeString(this.mCritical);
        dest.writeString(this.mFlags);
    }

    protected CountryWise(Parcel in) {
        this.mCovidCountry = in.readString();
        this.mCases = in.readString();
        this.mTodayCases = in.readString();
        this.mDeaths = in.readString();
        this.mTodayDeaths = in.readString();
        this.mRecovered = in.readString();
        this.mActive = in.readString();
        this.mCritical = in.readString();
        this.mFlags = in.readString();
    }

    public static final Creator<CountryWise> CREATOR = new Creator<CountryWise>() {
        @Override
        public CountryWise createFromParcel(Parcel source) {
            return new CountryWise(source);
        }

        @Override
        public CountryWise[] newArray(int size) {
            return new CountryWise[size];
        }
    };
}