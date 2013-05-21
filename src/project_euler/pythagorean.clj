(ns project-euler.pythagorean
  (:require
   [project-euler.math  :as m]
   [project-euler.utils  :as utils]

   )
  )




(defn pythagorean-triplet? [a b c]
  "a^2 + b^2 = c^2

  (pythagorean-triplet? 3 4 5)
  => true"
  (= (* c c) (+ (* a a) (* b b))))









