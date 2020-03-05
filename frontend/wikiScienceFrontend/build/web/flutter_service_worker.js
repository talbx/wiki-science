'use strict';
const CACHE_NAME = 'flutter-app-cache';
const RESOURCES = {
  "/index.html": "7c2c366ef9fee30b2f722b606c848f86",
"/main.dart.js": "eaf0a19ec97fc9b5c1ff0113c9ff05b6",
"/icons/Icon-192.png": "ac9a721a12bbc803b44f645561ecb1e1",
"/icons/Icon-512.png": "96e752610906ba2a93c65f8abe1645f1",
"/manifest.json": "b55aa9a052316d8b355a4050af5fd008",
"/assets/LICENSE": "a10e4e42ec7eeb5c9a75058b1b728631",
"/assets/images/contributor_count/contributorCount Dist.png": "d10ca9742fce22db12bd2feb4d52528f",
"/assets/images/ws_logo.png": "55e18e202aa4806e1f0d0dbdcc14d63d",
"/assets/images/contributors_10k/Top 10k.png": "1b9121a1b876993d29fb8ee09b2889c1",
"/assets/images/contributors_10k/Top 10k EU.png": "12f4f60394e452cfd6603ddf172e6916",
"/assets/images/contributors_10k/top10kworld.png": "1b9121a1b876993d29fb8ee09b2889c1",
"/assets/images/contributors_10k/Top 10k tops.png": "aeb88ad18bbaba43be41055ca8e66d69",
"/assets/images/contributors_10k/top10kEU.png": "12f4f60394e452cfd6603ddf172e6916",
"/assets/images/contributors_10k/top10ktops.png": "aeb88ad18bbaba43be41055ca8e66d69",
"/assets/images/contributions_10k/contributionsPerCountry EU.png": "ed225350e16302c3dd6668954bf4965e",
"/assets/images/contributions_10k/contributionsPerCountryWorld.png": "dc6e43013effb76f5ea492508982d909",
"/assets/images/contributions_10k/contributionsPerCountryBar.png": "f80c266b3f4653741f10c7b2da457f0f",
"/assets/images/contributions_10k/contributionsPerCountry Bar.png": "f80c266b3f4653741f10c7b2da457f0f",
"/assets/images/contributions_10k/contributionsPerCountry World.png": "dc6e43013effb76f5ea492508982d909",
"/assets/images/contributions_10k/contributionsPerCountryEU.png": "ed225350e16302c3dd6668954bf4965e",
"/assets/images/premium_contributor/premiumCont Graph.png": "4fc311206864c9ca1f46b215365a0c90",
"/assets/images/premium_contributor/premiumCont Bar.png": "d73c9585df31f3595baabe05eb9509de",
"/assets/images/article_length/sheet2.png": "38139448ef4dc68e8eb904a1d1412f8e",
"/assets/images/article_length/sheet1.JPG": "dabf6d283cdf812285702ff8b0e11655",
"/assets/images/top_100_editors/top100editors World.png": "35119d80a3846d2a6709c02303e37658",
"/assets/images/top_100_editors/Top 1k.png": "5e2b3083e1be29bde40955ba2b0279d9",
"/assets/images/top_100_editors/Top 1k full.png": "d80a3d5a8f2122334497f70e40601b70",
"/assets/images/top_100_editors/Top 1k3.png": "00797708ae4b503e92e06e48f0e4d3ea",
"/assets/images/top_100_editors/Top 1k2.png": "3810d4cab6f223cf2008f8cf010900b4",
"/assets/images/top_100_editors/top100editors Bar.png": "9a2a5946cd18edd0b18f3b38f23f764d",
"/assets/images/article _length/sheet2.png": "38139448ef4dc68e8eb904a1d1412f8e",
"/assets/images/article _length/sheet1.JPG": "dabf6d283cdf812285702ff8b0e11655",
"/assets/images/ws_front.png": "21e3167124871c854fef83ab92259891",
"/assets/images/premium _contributor/premiumCont Graph.png": "4fc311206864c9ca1f46b215365a0c90",
"/assets/images/premium _contributor/premiumCont Bar.png": "d73c9585df31f3595baabe05eb9509de",
"/assets/images/topics/topics Distr.JPG": "e402b913f5127cf08acaf91584e3dc0d",
"/assets/images/topics/topicsBars.JPG": "97627909a504a3fbce9af608ff927ae7",
"/assets/images/topics/topics Bars.JPG": "97627909a504a3fbce9af608ff927ae7",
"/assets/images/topics/topicsDistr.JPG": "e402b913f5127cf08acaf91584e3dc0d",
"/assets/web/assets/images/ws_logo.png": "55e18e202aa4806e1f0d0dbdcc14d63d",
"/assets/web/assets/images/contributors_10k/top10kworld.png": "1b9121a1b876993d29fb8ee09b2889c1",
"/assets/web/assets/images/contributors_10k/top10kEU.png": "12f4f60394e452cfd6603ddf172e6916",
"/assets/web/assets/images/contributors_10k/top10ktops.png": "aeb88ad18bbaba43be41055ca8e66d69",
"/assets/web/assets/images/contributions_10k/contributionsPerCountryWorld.png": "dc6e43013effb76f5ea492508982d909",
"/assets/web/assets/images/contributions_10k/contributionsPerCountryBar.png": "f80c266b3f4653741f10c7b2da457f0f",
"/assets/web/assets/images/contributions_10k/contributionsPerCountryEU.png": "ed225350e16302c3dd6668954bf4965e",
"/assets/web/assets/images/article_length/sheet2.png": "38139448ef4dc68e8eb904a1d1412f8e",
"/assets/web/assets/images/article_length/sheet1.JPG": "dabf6d283cdf812285702ff8b0e11655",
"/assets/web/assets/images/ws_front.png": "21e3167124871c854fef83ab92259891",
"/assets/web/assets/images/topics/topicsBars.JPG": "97627909a504a3fbce9af608ff927ae7",
"/assets/web/assets/images/topics/topicsDistr.JPG": "e402b913f5127cf08acaf91584e3dc0d",
"/assets/AssetManifest.json": "533729607750744fd5a0ce18285ce8ab",
"/assets/FontManifest.json": "01700ba55b08a6141f33e168c4a6c22f",
"/assets/packages/cupertino_icons/assets/CupertinoIcons.ttf": "115e937bb829a890521f72d2e664b632",
"/assets/fonts/MaterialIcons-Regular.ttf": "56d3ffdef7a25659eab6a68a3fbfaf16"
};

self.addEventListener('activate', function (event) {
  event.waitUntil(
    caches.keys().then(function (cacheName) {
      return caches.delete(cacheName);
    }).then(function (_) {
      return caches.open(CACHE_NAME);
    }).then(function (cache) {
      return cache.addAll(Object.keys(RESOURCES));
    })
  );
});

self.addEventListener('fetch', function (event) {
  event.respondWith(
    caches.match(event.request)
      .then(function (response) {
        if (response) {
          return response;
        }
        return fetch(event.request, {
          credentials: 'include'
        });
      })
  );
});
