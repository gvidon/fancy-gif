(ns fancy-gif.gif
  (:require
    [reagent.core :as reagent]))

(def is-gif-visible (reagent/atom false))

(defn gif [settings]
  (let [

    ; Setup observer with callback, must be connected after mount and disconnected on onmount
    observer (js/MutationObserver. (fn [mutations]
      (if (boolean (re-find #"uk-active" (aget (nth mutations 0) "target" "classList" "value")))
        (swap! is-gif-visible (fn [] true))
        (swap! is-gif-visible (fn [] false)))))]

    (reagent/create-class {
      :component-did-mount (fn []
        (.observe observer
          (.getElementById js/document "fancy-gif")
          (js-obj "attributeFilter" ["class"] "attributes" true)))

      :component-will-unmount (fn [] (.disconnect observer))

      :reagent-render (fn []
        [:li#fancy-gif [:img (if @is-gif-visible {:src "img/home.gif"} {:src ""})]])})))
