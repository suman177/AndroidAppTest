package com.example.asssessment.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GifResponseModel {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("next")
    @Expose
    private String next;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }


    public class Gif {

        @SerializedName("preview")
        @Expose
        private String preview;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

    }


    public class Medium {

        @SerializedName("mp4")
        @Expose
        private Mp4 mp4;
        @SerializedName("nanowebm")
        @Expose
        private Nanowebm nanowebm;
        @SerializedName("tinygif")
        @Expose
        private Tinygif tinygif;
        @SerializedName("mediumgif")
        @Expose
        private Mediumgif mediumgif;
        @SerializedName("loopedmp4")
        @Expose
        private Loopedmp4 loopedmp4;
        @SerializedName("tinywebm")
        @Expose
        private Tinywebm tinywebm;
        @SerializedName("nanomp4")
        @Expose
        private Nanomp4 nanomp4;
        @SerializedName("webm")
        @Expose
        private Webm webm;
        @SerializedName("tinymp4")
        @Expose
        private Tinymp4 tinymp4;
        @SerializedName("gif")
        @Expose
        private Gif gif;
        @SerializedName("nanogif")
        @Expose
        private Nanogif nanogif;

        public Mp4 getMp4() {
            return mp4;
        }

        public void setMp4(Mp4 mp4) {
            this.mp4 = mp4;
        }

        public Nanowebm getNanowebm() {
            return nanowebm;
        }

        public void setNanowebm(Nanowebm nanowebm) {
            this.nanowebm = nanowebm;
        }

        public Tinygif getTinygif() {
            return tinygif;
        }

        public void setTinygif(Tinygif tinygif) {
            this.tinygif = tinygif;
        }

        public Mediumgif getMediumgif() {
            return mediumgif;
        }

        public void setMediumgif(Mediumgif mediumgif) {
            this.mediumgif = mediumgif;
        }

        public Loopedmp4 getLoopedmp4() {
            return loopedmp4;
        }

        public void setLoopedmp4(Loopedmp4 loopedmp4) {
            this.loopedmp4 = loopedmp4;
        }

        public Tinywebm getTinywebm() {
            return tinywebm;
        }

        public void setTinywebm(Tinywebm tinywebm) {
            this.tinywebm = tinywebm;
        }

        public Nanomp4 getNanomp4() {
            return nanomp4;
        }

        public void setNanomp4(Nanomp4 nanomp4) {
            this.nanomp4 = nanomp4;
        }

        public Webm getWebm() {
            return webm;
        }

        public void setWebm(Webm webm) {
            this.webm = webm;
        }

        public Tinymp4 getTinymp4() {
            return tinymp4;
        }

        public void setTinymp4(Tinymp4 tinymp4) {
            this.tinymp4 = tinymp4;
        }

        public Gif getGif() {
            return gif;
        }

        public void setGif(Gif gif) {
            this.gif = gif;
        }

        public Nanogif getNanogif() {
            return nanogif;
        }

        public void setNanogif(Nanogif nanogif) {
            this.nanogif = nanogif;
        }

    }


    public class Mediumgif {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("preview")
        @Expose
        private String preview;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

    }


    public class Mp4 {

        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("preview")
        @Expose
        private String preview;
        @SerializedName("duration")
        @Expose
        private Double duration;

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public Double getDuration() {
            return duration;
        }

        public void setDuration(Double duration) {
            this.duration = duration;
        }

    }


    public class Nanogif {

        @SerializedName("preview")
        @Expose
        private String preview;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("size")
        @Expose
        private Integer size;

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

    }


    public class Nanomp4 {

        @SerializedName("preview")
        @Expose
        private String preview;
        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("duration")
        @Expose
        private Double duration;
        @SerializedName("url")
        @Expose
        private String url;

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Double getDuration() {
            return duration;
        }

        public void setDuration(Double duration) {
            this.duration = duration;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


    public class Nanowebm {

        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("preview")
        @Expose
        private String preview;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("size")
        @Expose
        private Integer size;

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

    }


    public class Result {


        @SerializedName("media")
        @Expose
        private List<Medium> media = null;

        public List<Medium> getMedia() {
            return media;
        }

        public void setMedia(List<Medium> media) {
            this.media = media;
        }

    }


    public class Tinygif {

        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("preview")
        @Expose
        private String preview;

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

    }


    public class Tinymp4 {

        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("preview")
        @Expose
        private String preview;
        @SerializedName("duration")
        @Expose
        private Double duration;
        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("url")
        @Expose
        private String url;

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public Double getDuration() {
            return duration;
        }

        public void setDuration(Double duration) {
            this.duration = duration;
        }

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


    public class Tinywebm {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("preview")
        @Expose
        private String preview;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

    }


    public class Webm {

        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("preview")
        @Expose
        private String preview;
        @SerializedName("url")
        @Expose
        private String url;

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


    public class Loopedmp4 {

        @SerializedName("dims")
        @Expose
        private List<Integer> dims = null;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("duration")
        @Expose
        private Double duration;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("preview")
        @Expose
        private String preview;

        public List<Integer> getDims() {
            return dims;
        }

        public void setDims(List<Integer> dims) {
            this.dims = dims;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Double getDuration() {
            return duration;
        }

        public void setDuration(Double duration) {
            this.duration = duration;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }


    }

}
