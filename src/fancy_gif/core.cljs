(ns fancy-gif.core
  (:require
    [fancy-gif.gif :refer [gif]]
    [reagent.core :as reagent]))

(defn app []
  [:div.uk-container.uk-width-1-1.uk-flex.uk-flex-center.uk-margin-large-top
    [:div.uk-position-relative.uk-light
      {
        "data-uk-slideshow" "autoplay: true; autoplay-interval: 2400"
        :style {:height "316px" :width "486px"}}

      [:ul.uk-slideshow-items {:style {:box-shadow "#ccc 8px 8px 48px"}}
        [:li.uk-flex.uk-flex-center.uk-flex-middle "3..."]
        [:li.uk-flex.uk-flex-center.uk-flex-middle "2..."]
        [gif]]

      [:div.uk-position-bottom-center.uk-position-small.uk-margin-top-large
        [:ul.uk-dotnav
          [:li {"data-uk-slideshow-item" "0"} [:a {:href "#"} "Item 1"]]
          [:li {"data-uk-slideshow-item" "1"} [:a {:href "#"} "Item 2"]]
          [:li {"data-uk-slideshow-item" "2"} [:a {:href "#"} "Item 3"]]]]]])

(defn run []
  (reagent/render [app] (js/document.getElementById "app")))
