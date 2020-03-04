'use strict';
const CACHE_NAME = 'flutter-app-cache';
const RESOURCES = {
  "/index.html": "7c2c366ef9fee30b2f722b606c848f86",
"/main.dart.js": "02784716f1dfb63cabbd6d1f0d6ef2ff",
"/icons/Icon-192.png": "ac9a721a12bbc803b44f645561ecb1e1",
"/icons/Icon-512.png": "96e752610906ba2a93c65f8abe1645f1",
"/manifest.json": "b55aa9a052316d8b355a4050af5fd008",
"/assets/LICENSE": "a10e4e42ec7eeb5c9a75058b1b728631",
"/assets/images/ws_logo.png": "55e18e202aa4806e1f0d0dbdcc14d63d",
"/assets/images/answerGallerie/picture1.png": "d7ec16a178c827483a8ab659c74a47b1",
"/assets/images/answerGallerie/picture2.png": "37cb8e234f32ebc37233615efb2c8a95",
"/assets/images/answerGallerie/picture3.png": "dc9b372ae49cb28bd87cf5c6f74da18a",
"/assets/images/ws_front.png": "21e3167124871c854fef83ab92259891",
"/assets/web/assets/images/ws_logo.png": "55e18e202aa4806e1f0d0dbdcc14d63d",
"/assets/web/assets/images/answerGallerie/picture1.png": "d7ec16a178c827483a8ab659c74a47b1",
"/assets/web/assets/images/answerGallerie/picture2.png": "37cb8e234f32ebc37233615efb2c8a95",
"/assets/web/assets/images/answerGallerie/picture3.png": "dc9b372ae49cb28bd87cf5c6f74da18a",
"/assets/web/assets/images/ws_front.png": "21e3167124871c854fef83ab92259891",
"/assets/AssetManifest.json": "ec6492427d2a46534ecc30ee93d4dd36",
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
