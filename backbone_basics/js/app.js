Backbone.emulateHTTP = true;
Backbone.emulateJSON = true;

var TagModel = Backbone.Model.extend({
    defaults: {
        name: "defaultName"
    },
    initialize: function () {
        console.log("initialize TagModel.");
    }
});

var tagModel = new TagModel();

var BookmarkModel = Backbone.Model.extend({
    defaults: {
        url: "http://default",
        title: "defaultTitle",
        tags: []
    },
    url: "/backbone_basics/api/Bookmark.php",
    initialize: function () {
        console.log("initialize BookmarkModel")
    },
    validate: function (attr, options) {
        return !(attr.tag || attr.url);
    }
});

var bookmarkModel = new BookmarkModel();

var BookmarkListCollection = Backbone.Collection.extend({
    model: BookmarkModel,
    url: "/backbone_basics/api/BookmarkList.php"
});

var TagListCollection = Backbone.Collection.extend({
    model: TagModel,
    url: "/api/TagList.php"
});

var BookmarkView = Backbone.View.extend({
    el: $("#bookmark"),
    //tagName: 'li',
    template: "<li id='bookmark'><button id='btnEdit' class='btn btn-default'>Edit</button><button id='btnDelete' class='btn btn-danger'>Delete</button><%= title %>(<%= url %>)</li>",
    events: {
        "click #btnDelete": "deleteBookmark",
        "click #btnEdit": "editBookmark"
    },
    render: function (event) {
        console.log("render BookmarkView");
        //this.$el.html(_.template(this.template, this.model.toJSON()));
        $('#bookmarkList').append(_.template(this.template, this.model.toJSON()));
        return this;
    },
    deleteBookmark: function () {
        console.log("Destroy bookmark!");
        this.model.destroy();

    },
    editBookmark: function () {
        console.log("Edit bookmark");
    }
});

var BookmarkListView = Backbone.View.extend({
    el: $("#bookmarkList"),
    initialize: function () {
        console.log("initialize BookmarkListView");
    },
    render: function (event) {
        console.log("render BookmarkListView");
        //var template = _.template($('#bookmark-list-template').html(), {bookmarkModels: this.collection.models});
        //this.$el.html(template);
        $("#bookmarkList").empty();
        _.each(this.collection.models, function (bookmarkModel) {
            var bookmarkView = new BookmarkView({model: bookmarkModel});
            bookmarkView.render();
        });
        return this;
    }

});

var BookmarkFormView = Backbone.View.extend({
    el: $("#form"),
    initialize: function () {
        console.log("initialize BookmarkFormView");
    },
    events: {
        "click #btnSave": "saveBookmark",
        "click #btnClear": "clearBookmark"
    },
    render: function (event) {
        console.log("render BookmarkFormView");
        $(this.el).find('#url').val(this.model.get('url'));
        $(this.el).find('#title').val(this.model.get('title'));
        $(this.el).find('#tags').val('');
    },
    saveBookmark: function () {
        console.log("Save button was clicked");
        var urlValue = $(this.el).find('#url').val();
        this.model.set('url', urlValue);
        var titleValue = $(this.el).find('#title').val();
        this.model.set('title', titleValue);
        this.model.save();
        globalEvent.trigger("saveBookmark");
    },
    clearBookmark: function () {
        console.log("Clear bookmark");
        $(this.el).find('#url').val('');
        $(this.el).find('#title').val('');
        $(this.el).find('#tags').val('');
    }
});

var Router = Backbone.Router.extend({
    routes: {
        "*other": "defaultRouter"
    },
    defaultRouter: function (other) {
        loadBookmarkListCollection();
    }
});

var router = new Router();

var bookmarkListCollection = new BookmarkListCollection();
Backbone.history.start();

var bookmarkFormview = new BookmarkFormView({model: bookmarkModel});

var bookmarkListView;

function loadBookmarkListCollection() {
    bookmarkListCollection.fetch({
        success: function (collection) {
            console.log("BookmarkList was loaded from server.");
            bookmarkListView = new BookmarkListView({collection: bookmarkListCollection});
            bookmarkListView.render();
        }, error: function () {
            console.log("error!!!");
        }
    });
}

var globalEvent = _.extend({}, Backbone.Events);

globalEvent.on("saveBookmark", function () {
    loadBookmarkListCollection();
});


